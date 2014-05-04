package rubikcubeanimationexample;

import java.util.Random;

import rubikcubeanimationexample.Cube;
import rubiks.cs196.Permutation;
import rubiks.cs196.R;
import rubiks.cs196.solveCube;
import android.app.Activity;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RubikCubeAnimationExampleActivity extends Activity implements
		KubeRenderer.AnimationCallback {

	private GLWorld makeGLWorld() {
		GLWorld world = new GLWorld();

		float c0 = -1.0f;
		float c1 = -0.38f;
		float c2 = -0.32f;
		float c3 = 0.32f;
		float c4 = 0.38f;
		float c5 = 1.0f;

		// top back, left to right
		mCubes[0] = new Cube(world, c0, c4, c0, c1, c5, c1);
		mCubes[1] = new Cube(world, c2, c4, c0, c3, c5, c1);
		mCubes[2] = new Cube(world, c4, c4, c0, c5, c5, c1);
		// top middle, left to right
		mCubes[3] = new Cube(world, c0, c4, c2, c1, c5, c3);
		mCubes[4] = new Cube(world, c2, c4, c2, c3, c5, c3);
		mCubes[5] = new Cube(world, c4, c4, c2, c5, c5, c3);
		// top front, left to right
		mCubes[6] = new Cube(world, c0, c4, c4, c1, c5, c5);
		mCubes[7] = new Cube(world, c2, c4, c4, c3, c5, c5);
		mCubes[8] = new Cube(world, c4, c4, c4, c5, c5, c5);
		// middle back, left to right
		mCubes[9] = new Cube(world, c0, c2, c0, c1, c3, c1);
		mCubes[10] = new Cube(world, c2, c2, c0, c3, c3, c1);
		mCubes[11] = new Cube(world, c4, c2, c0, c5, c3, c1);
		// middle middle, left to right
		mCubes[12] = new Cube(world, c0, c2, c2, c1, c3, c3);
		mCubes[13] = null;
		mCubes[14] = new Cube(world, c4, c2, c2, c5, c3, c3);
		// middle front, left to right
		mCubes[15] = new Cube(world, c0, c2, c4, c1, c3, c5);
		mCubes[16] = new Cube(world, c2, c2, c4, c3, c3, c5);
		mCubes[17] = new Cube(world, c4, c2, c4, c5, c3, c5);
		// bottom back, left to right
		mCubes[18] = new Cube(world, c0, c0, c0, c1, c1, c1);
		mCubes[19] = new Cube(world, c2, c0, c0, c3, c1, c1);
		mCubes[20] = new Cube(world, c4, c0, c0, c5, c1, c1);
		// bottom middle, left to right
		mCubes[21] = new Cube(world, c0, c0, c2, c1, c1, c3);
		mCubes[22] = new Cube(world, c2, c0, c2, c3, c1, c3);
		mCubes[23] = new Cube(world, c4, c0, c2, c5, c1, c3);
		// bottom front, left to right
		mCubes[24] = new Cube(world, c0, c0, c4, c1, c1, c5);
		mCubes[25] = new Cube(world, c2, c0, c4, c3, c1, c5);
		mCubes[26] = new Cube(world, c4, c0, c4, c5, c1, c5);

		// paint the sides
		int i, j, k, l;
		// set all faces black by default
		for (i = 0; i < 27; i++) {
			Cube cube = mCubes[i];
			if (cube != null) {
				for (j = 0; j < 6; j++)
					cube.setFaceColor(j, 'Z');
			}
		}

		// paint top (white)
		for (i = 0, j = 36; i < 9; i++, j++)
			mCubes[i].setFaceColor(Cube.kTop, rubiks.cs196.Cube.getColor(j));
		// paint bottom (yellow)
		mCubes[18].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(51));
		mCubes[19].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(52));
		mCubes[20].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(53));
		mCubes[21].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(48));
		mCubes[22].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(49));
		mCubes[23].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(50));
		mCubes[24].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(45));
		mCubes[25].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(46));
		mCubes[26].setFaceColor(Cube.kBottom, rubiks.cs196.Cube.getColor(47));
		// paint left (orange)
		for (i = 0, j = 27; i < 27; i += 3, j++)
			mCubes[i].setFaceColor(Cube.kLeft, rubiks.cs196.Cube.getColor(j));
		// paint right (red)
		mCubes[8].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(9));
		mCubes[5].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(10));
		mCubes[2].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(11));
		mCubes[17].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(12));
		mCubes[14].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(13));
		mCubes[11].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(14));
		mCubes[26].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(15));
		mCubes[23].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(16));
		mCubes[20].setFaceColor(Cube.kRight, rubiks.cs196.Cube.getColor(17));
		// paint back b
		mCubes[2].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(18));
		mCubes[1].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(19));
		mCubes[0].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(20));
		mCubes[11].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(21));
		mCubes[10].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(22));
		mCubes[9].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(23));
		mCubes[20].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(24));
		mCubes[19].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(25));
		mCubes[18].setFaceColor(Cube.kBack, rubiks.cs196.Cube.getColor(26));
		// paint front (green)
		for (i = 6, k = 0; i < 27; i += 9, k += 3)
			for (j = 0, l = 0; j < 3; j++, l++)
				mCubes[i + j].setFaceColor(Cube.kFront,
						rubiks.cs196.Cube.getColor(k + l));

		for (i = 0; i < 27; i++)
			if (mCubes[i] != null)
				world.addShape(mCubes[i]);

		// initialize our permutation to solved position
		mPermutation = new int[27];
		for (i = 0; i < mPermutation.length; i++)
			mPermutation[i] = i;

		createLayers();
		updateLayers();

		world.generate();

		return world;
	}

	private void createLayers() {
		mLayers[kUp] = new Layer(Layer.kAxisY);
		mLayers[kDown] = new Layer(Layer.kAxisY);
		mLayers[kLeft] = new Layer(Layer.kAxisX);
		mLayers[kRight] = new Layer(Layer.kAxisX);
		mLayers[kFront] = new Layer(Layer.kAxisZ);
		mLayers[kBack] = new Layer(Layer.kAxisZ);
		mLayers[kMiddle] = new Layer(Layer.kAxisX);
		mLayers[kEquator] = new Layer(Layer.kAxisY);
		mLayers[kSide] = new Layer(Layer.kAxisZ);
	}

	private void updateLayers() {
		Layer layer;
		GLShape[] shapes;
		int i, j, k;

		// up layer
		layer = mLayers[kUp];
		shapes = layer.mShapes;
		for (i = 0; i < 9; i++)
			shapes[i] = mCubes[mPermutation[i]];

		// down layer
		layer = mLayers[kDown];
		shapes = layer.mShapes;
		for (i = 18, k = 0; i < 27; i++)
			shapes[k++] = mCubes[mPermutation[i]];

		// left layer
		layer = mLayers[kLeft];
		shapes = layer.mShapes;
		for (i = 0, k = 0; i < 27; i += 9)
			for (j = 0; j < 9; j += 3)
				shapes[k++] = mCubes[mPermutation[i + j]];

		// right layer
		layer = mLayers[kRight];
		shapes = layer.mShapes;
		for (i = 2, k = 0; i < 27; i += 9)
			for (j = 0; j < 9; j += 3)
				shapes[k++] = mCubes[mPermutation[i + j]];

		// front layer
		layer = mLayers[kFront];
		shapes = layer.mShapes;
		for (i = 6, k = 0; i < 27; i += 9)
			for (j = 0; j < 3; j++)
				shapes[k++] = mCubes[mPermutation[i + j]];

		// back layer
		layer = mLayers[kBack];
		shapes = layer.mShapes;
		for (i = 0, k = 0; i < 27; i += 9)
			for (j = 0; j < 3; j++)
				shapes[k++] = mCubes[mPermutation[i + j]];

		// middle layer
		layer = mLayers[kMiddle];
		shapes = layer.mShapes;
		for (i = 1, k = 0; i < 27; i += 9)
			for (j = 0; j < 9; j += 3)
				shapes[k++] = mCubes[mPermutation[i + j]];

		// equator layer
		layer = mLayers[kEquator];
		shapes = layer.mShapes;
		for (i = 9, k = 0; i < 18; i++)
			shapes[k++] = mCubes[mPermutation[i]];

		// side layer
		layer = mLayers[kSide];
		shapes = layer.mShapes;
		for (i = 3, k = 0; i < 27; i += 9)
			for (j = 0; j < 3; j++)
				shapes[k++] = mCubes[mPermutation[i + j]];
	}

	public static String msg = "";
	public static boolean paused = true;
	public static boolean useTestCube = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (useTestCube) {
			String stringCube = "BWWBGRBOGRBGBRORGORROGBGWBYYGOROWRROGWWWWOYOBWYYYYYBYG";
			rubiks.cs196.Cube.setTo(stringCube.toCharArray());
		}
		/** SOLVECUBE in another thread **/
		new Thread(new Runnable() {
			public void run() {
				solveCube.main();
			}
		}).start();

		// We don't need a title either.
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		/** Set up views and renderer **/
		setContentView(R.layout.overlay_test);
		mView = (GLSurfaceView) findViewById(R.id.surface);
		// mView = new GLSurfaceView(getApplication());
		mRenderer = new KubeRenderer(makeGLWorld(), this);
		mView.setRenderer(mRenderer);

		/** Set up buttons and instruction box **/
		FrameLayout frm = (FrameLayout) findViewById(R.id.frameLayout2);
		frm.setBackgroundColor(Color.BLACK);
		final TextView instructionBox = (TextView) findViewById(R.id.textView1);
		instructionBox.setMovementMethod(new ScrollingMovementMethod());
		final Button button1 = (Button) findViewById(R.id.button2);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				paused = false;
				instructionBox.setText(msg);
				button1.setText("Next");
			}
		});

	}

	@Override
	protected void onResume() {
		super.onResume();
		mView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mView.onPause();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
			mView.queueEvent(new Runnable() {
				// This method will be called on the rendering
				// thread:
				public void run() {
					rotateFace(2, true);
				}
			});
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	public static boolean n = true;
	public static int mLayerID = 0;
	public static boolean rotate = false;

	public static void rotateFace(int face, boolean direction) {
		if (!rotate) {
			face=Permutation.convertFace(face);
			mLayerID = face;
			rotate = true;
		}
	}

	private float touchTurn = 0;
	private float touchTurnUp = 0;
	private float touchTurnSpeed = 25.0f;

	private float xpos = -1;
	private float ypos = -1;

	public boolean onTouchEvent(MotionEvent me) {

		if (me.getAction() == MotionEvent.ACTION_DOWN) {
			xpos = me.getX();
			ypos = me.getY();
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

	public void animate() {
		if (n) {
			// change our angle of view
			// mRenderer.setAngleX(200.0f);
			// mRenderer.setAngleY(200.0f);
			n = false;
		}

		if (touchTurn != 0) {
			mRenderer.setAngleY(mRenderer.getAngleY() + -touchTurn
					* touchTurnSpeed);
			touchTurn = 0;
		}

		if (touchTurnUp != 0) {
			mRenderer.setAngleX(mRenderer.getAngleX() + -touchTurnUp
					* touchTurnSpeed);
			touchTurnUp = 0;
		}

		if (rotate) {
			if (mCurrentLayer == null) {
				mCurrentLayer = mLayers[mLayerID];
				mCurrentLayerPermutation = mLayerPermutations[mLayerID];
				mCurrentLayer.startAnimation();
				boolean direction = mRandom.nextBoolean();
				int count = mRandom.nextInt(3) + 1;

				count = 1;
				direction = false;
				mCurrentAngle = 0;
				if (direction) {
					mAngleIncrement = (float) Math.PI / 10;
					mEndAngle = mCurrentAngle + ((float) Math.PI * count) / 2f;
				} else {
					mAngleIncrement = -(float) Math.PI / 10;
					mEndAngle = mCurrentAngle - ((float) Math.PI * count) / 2f;
				}
			}

			mCurrentAngle += mAngleIncrement;

			if ((mAngleIncrement > 0f && mCurrentAngle >= mEndAngle)
					|| (mAngleIncrement < 0f && mCurrentAngle <= mEndAngle)) {
				rotate = false;
				mCurrentLayer.setAngle(mEndAngle);
				mCurrentLayer.endAnimation();
				mCurrentLayer = null;

				// adjust mPermutation based on the completed layer rotation
				int[] newPermutation = new int[27];
				for (int i = 0; i < 27; i++) {
					newPermutation[i] = mPermutation[mCurrentLayerPermutation[i]];
				}
				mPermutation = newPermutation;
				updateLayers();

			} else {
				mCurrentLayer.setAngle(mCurrentAngle);
			}
		}
	}

	GLSurfaceView mView;
	KubeRenderer mRenderer;
	Cube[] mCubes = new Cube[27];
	// a Layer for each possible move
	Layer[] mLayers = new Layer[9];
	// permutations corresponding to a pi/2 rotation of each layer about its
	// axis
	static int[][] mLayerPermutations = {
			// permutation for UP layer
			{ 2, 5, 8, 1, 4, 7, 0, 3, 6, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
					19, 20, 21, 22, 23, 24, 25, 26 },
			// permutation for DOWN layer
			{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 20,
					23, 26, 19, 22, 25, 18, 21, 24 },
			// permutation for LEFT layer
			{ 6, 1, 2, 15, 4, 5, 24, 7, 8, 3, 10, 11, 12, 13, 14, 21, 16, 17,
					0, 19, 20, 9, 22, 23, 18, 25, 26 },
			// permutation for RIGHT layer
			{ 0, 1, 8, 3, 4, 17, 6, 7, 26, 9, 10, 5, 12, 13, 14, 15, 16, 23,
					18, 19, 2, 21, 22, 11, 24, 25, 20 },
			// permutation for FRONT layer
			{ 0, 1, 2, 3, 4, 5, 24, 15, 6, 9, 10, 11, 12, 13, 14, 25, 16, 7,
					18, 19, 20, 21, 22, 23, 26, 17, 8 },
			// permutation for BACK layer
			{ 18, 9, 0, 3, 4, 5, 6, 7, 8, 19, 10, 1, 12, 13, 14, 15, 16, 17,
					20, 11, 2, 21, 22, 23, 24, 25, 26 },
			// permutation for MIDDLE layer
			{ 0, 7, 2, 3, 16, 5, 6, 25, 8, 9, 4, 11, 12, 13, 14, 15, 22, 17,
					18, 1, 20, 21, 10, 23, 24, 19, 26 },
			// permutation for EQUATOR layer
			{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 11, 14, 17, 10, 13, 16, 9, 12, 15, 18,
					19, 20, 21, 22, 23, 24, 25, 26 },
			// permutation for SIDE layer
			{ 0, 1, 2, 21, 12, 3, 6, 7, 8, 9, 10, 11, 22, 13, 4, 15, 16, 17,
					18, 19, 20, 23, 14, 5, 24, 25, 26 } };

	// current permutation of starting position
	int[] mPermutation;

	static// for random cube movements
	Random mRandom = new Random(System.currentTimeMillis());
	// currently turning layer
	Layer mCurrentLayer = null;
	// current and final angle for current Layer animation
	float mCurrentAngle, mEndAngle;
	// amount to increment angle
	float mAngleIncrement;
	int[] mCurrentLayerPermutation;

	// names for our 9 layers (based on notation from
	// http://www.cubefreak.net/notation.html)
	static final int kUp = 0;
	static final int kDown = 1;
	static final int kLeft = 2;
	static final int kRight = 3;
	static final int kFront = 4;
	static final int kBack = 5;
	static final int kMiddle = 6;
	static final int kEquator = 7;
	static final int kSide = 8;

}