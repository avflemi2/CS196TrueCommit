package rubiks.cs196;

import java.io.FileInputStream;
import java.lang.reflect.Field;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLUtils;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.threed.jpct.Camera;
import com.threed.jpct.FrameBuffer;
import com.threed.jpct.Light;
import com.threed.jpct.Loader;
import com.threed.jpct.Logger;
import com.threed.jpct.Object3D;
import com.threed.jpct.Primitives;
import com.threed.jpct.RGBColor;
import com.threed.jpct.SimpleVector;
import com.threed.jpct.Texture;
import com.threed.jpct.TextureManager;
import com.threed.jpct.World;
import com.threed.jpct.util.BitmapHelper;
import com.threed.jpct.util.MemoryHelper;
import com.threed.jpct.util.Overlay;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * A simple demo. This shows more how to use jPCT-AE than it shows how to write
 * a proper application for Android. It includes basic activity management to
 * handle pause and resume...
 * 
 * @author EgonOlsen
 * 
 */
public class HelloWorld extends Activity {

	// Used to handle pause and resume...
	private static HelloWorld master = null;

	// FrameLayout frame = (FrameLayout)
	// findViewById(R.id.graphics_frameLayout1);
	// GLSurfaceView mGLView = (GLSurfaceView)
	// findViewById(R.id.graphics_glsurfaceview1);
	private GLSurfaceView mGLView;
	private MyRenderer renderer = null;
	private FrameBuffer fb = null;
	private World world = null;
	private RGBColor back = new RGBColor(0, 0, 0);

	private float touchTurn = 0;
	private float touchTurnUp = 0;

	private float xpos = -1;
	private float ypos = -1;

	private Object3D centerCube = null;
	private Object3D tst = null;
	private int fps = 0;

	private Light sun = null;

	// overlay
	private int o_width = 500;
	private int o_height = 150;

	protected void onCreate(Bundle savedInstanceState) {

		Logger.log("onCreate");

		if (master != null) {
			copy(master);
		}

		super.onCreate(savedInstanceState);
		// RelativeLayout mGLView = (RelativeLayout) findViewById(R.id.rel1);
		mGLView = new GLSurfaceView(getApplication());

		mGLView.setEGLConfigChooser(new GLSurfaceView.EGLConfigChooser() {
			public EGLConfig chooseConfig(EGL10 egl, EGLDisplay display) {
				// Ensure that we get a 16bit framebuffer. Otherwise, we'll fall
				// back to Pixelflinger on some device (read: Samsung I7500)
				int[] attributes = new int[] { EGL10.EGL_DEPTH_SIZE, 16,
						EGL10.EGL_NONE };
				EGLConfig[] configs = new EGLConfig[1];
				int[] result = new int[1];
				egl.eglChooseConfig(display, attributes, configs, 1, result);
				return configs[0];
			}
		});

		renderer = new MyRenderer();
		mGLView.setRenderer(renderer);
		setContentView(mGLView);

		// // view = new MyGLSurfaceView(this, gameHandler);
		// EditText editBox = new EditText(getBaseContext());
		// editBox.setText("Hello Matron");

		// mGLView.setRenderer(renderer);
		// setContentView(mGLView);

		// setContentView(editBox, new
		// ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
		// ViewGroup.LayoutParams.WRAP_CONTENT));
	}

	@Override
	protected void onPause() {
		super.onPause();
		mGLView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mGLView.onResume();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	private void copy(Object src) {
		try {
			Logger.log("Copying data from master Activity!");
			Field[] fs = src.getClass().getDeclaredFields();
			for (Field f : fs) {
				f.setAccessible(true);
				f.set(this, f.get(src));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean onTouchEvent(MotionEvent me) {

		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			xpos = me.getX();
			ypos = me.getY();

			if (ypos < o_height + 100) {
				mGLView.queueEvent(new Runnable() {
					// This method will be called on the rendering
					// thread:
					public void run() {
						renderer.makeExtra();
					}
				});
			}

			return true;
		}

		if (me.getAction() == MotionEvent.ACTION_UP) {
			xpos = -1;
			ypos = -1;
			touchTurn = 0;
			touchTurnUp = 0;
			return true;
		}

		if (me.getAction() == MotionEvent.ACTION_MOVE) {
			float xd = me.getX() - xpos;
			float yd = me.getY() - ypos;

			xpos = me.getX();
			ypos = me.getY();

			touchTurn = xd / -100f;
			touchTurnUp = yd / -100f;
			return true;

		}

		try {
			Thread.sleep(15);
		} catch (Exception e) {
			// No need for this...
		}

		return super.onTouchEvent(me);
	}

	// trying to sync threads
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
			mGLView.queueEvent(new Runnable() {
				// This method will be called on the rendering
				// thread:
				public void run() {
					renderer.makeExtra();
				}
			});
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	protected boolean isFullscreenOpaque() {
		return true;
	}

	class MyRenderer implements GLSurfaceView.Renderer {

		private long time = System.currentTimeMillis();

		public MyRenderer() {
		}

		public void onSurfaceChanged(GL10 gl, int w, int h) {
			if (fb != null) {
				fb.dispose();
			}
			fb = new FrameBuffer(gl, w, h);

			if (master == null) {

				world = new World();
				world.setAmbientLight(20, 20, 20);

				sun = new Light(world);
				sun.setIntensity(250, 250, 250);

				// Create a texture out of the icon...:-)
				Texture texture = new Texture(BitmapHelper.rescale(
						BitmapHelper.convert(getResources().getDrawable(
								R.drawable.grid)), 64, 64));
				TextureManager.getInstance().addTexture("cube1.png", texture);
				
				createCube();

				Camera cam = world.getCamera();
				cam.moveCamera(Camera.CAMERA_MOVEOUT, 50);
				cam.lookAt(centerCube.getTransformedCenter());

				Overlay myMessages = new Overlay(world, 0, 0, o_width,
						o_height, "cube1.png");
				
				/***** solveCube *****/
				solveCube.run(getApplicationContext());

				if (master == null) {
					Logger.log("Saving master Activity!");
					master = HelloWorld.this;
				}
			}
		}

		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		}

		public void onDrawFrame(GL10 gl) {
			
			if (touchTurn != 0) {
				centerCube.rotateY(touchTurn);
				touchTurn = 0;
			}

			if (touchTurnUp != 0) {
				centerCube.rotateX(touchTurnUp);
				touchTurnUp = 0;
			}

			fb.clear(back);
			world.renderScene(fb);
			world.draw(fb);		
			fb.display();
			
			if (System.currentTimeMillis() - time >= 1000) {
				Logger.log(fps + "fps");
				fps = 0;
				time = System.currentTimeMillis();
			}
			fps++;
		}

		public void createCube() {

			centerCube = Primitives.getCube(10);
			centerCube.rotateY((float) (Math.PI / 4.0)); // cube primitive is
															// offset
			centerCube.calcTextureWrap();
			// cube2.setAdditionalColor(0, 0, 208);
			centerCube.setTexture("cube1.png");
			centerCube.strip();
			centerCube.build();

			centerCube.scale(0.5f);
			world.addObject(centerCube);

			SimpleVector sv = new SimpleVector();
			sv.set(centerCube.getTransformedCenter());
			sv.y -= 100;
			sv.z -= 100;
			sun.setPosition(sv);
			MemoryHelper.compact();

			Object3D[] Cubies = new Object3D[Cubelets.number];
			for (int i = 0; i < Cubies.length; i++) {
				Cubies[i] = Primitives.getCube(5);
				// Cubies[i]=load3DS("cube0.3ds",5.0);
				Cubies[i].rotateY((float) (Math.PI / 4.0)); // offset
				Cubies[i].scale(2.0f);
				Cubies[i].translate(Cubelets.getCoords(i));
				Cubies[i].calcTextureWrap();
				Cubies[i].setTexture("cube1.png");
				Cubies[i].addParent(centerCube);
				Cubies[i].strip();
				Cubies[i].build();
				world.addObject(Cubies[i]);

				// set new axes for rotating entire cube
				// centerCube.setRotationPivot(new SimpleVector(20,0,0));
				// centerCube.setOrigin(new SimpleVector(-20,0,0));
			}
		}

		public void makeExtra() {
			if (tst != null) {
				world.removeObject(tst);
				tst = null;
				return;
			}
			tst = Primitives.getCube(10);
			tst.rotateY((float) (Math.PI / 4.0)); // cube primitive is
			tst.translate(30, 30, 30);
			tst.addParent(centerCube);
			// offset
			tst.calcTextureWrap();
			// cube2.setAdditionalColor(0, 0, 208);
			tst.setTexture("cube1.png");
			tst.strip();
			tst.build();

			tst.scale(0.5f);
			world.addObject(tst);

			SimpleVector sv = new SimpleVector();
			sv.set(tst.getTransformedCenter());
			sv.y -= 100;
			sv.z -= 100;
			sun.setPosition(sv);
			MemoryHelper.compact();

		}

	}
}