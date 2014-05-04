package openglcube;

import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class GLShape {
	
	int one = 0x10000;
	int half = 0x08000;
	GLColor red = new GLColor(one, 0, 0);
	GLColor green = new GLColor(0, one, 0);
	GLColor blue = new GLColor(0, 0, one);
	GLColor yellow = new GLColor(one, one, 0);
	GLColor orange = new GLColor(one, half, 0);
	GLColor white = new GLColor(one, one, one);
	GLColor black = new GLColor(0, 0, 0);

	public GLShape(GLWorld world) {
		mWorld = world;
	}
	
	public void addFace(GLFace face) {
		mFaceList.add(face);
	}
	
	public void setFaceColor(int face, char color) {
		GLColor mGLColor = null;
		if (color == 'G') mGLColor = green;
		if (color == 'R') mGLColor = red;
		if (color == 'B') mGLColor = blue;
		if (color == 'O') mGLColor = orange;
		if (color == 'Y') mGLColor = yellow;
		if (color == 'W') mGLColor = white;
		if (color == 'Z') mGLColor = black;
		mFaceList.get(face).setColor(mGLColor);
	}
			
	public void putIndices(ShortBuffer buffer) {
		Iterator<GLFace> iter = mFaceList.iterator();
		while (iter.hasNext()) {
			GLFace face = iter.next();
			face.putIndices(buffer);
		}		
	}
	
	public int getIndexCount() {
		int count = 0;
		Iterator<GLFace> iter = mFaceList.iterator();
		while (iter.hasNext()) {
			GLFace face = iter.next();
			count += face.getIndexCount();
		}		
		return count;
	}

	public GLVertex addVertex(float x, float y, float z) {
		
		// look for an existing GLVertex first
		Iterator<GLVertex> iter = mVertexList.iterator();
		while (iter.hasNext()) {
			GLVertex vertex = iter.next();
			if (vertex.x == x && vertex.y == y && vertex.z == z) {
				return vertex;
			}
		}
		
		// doesn't exist, so create new vertex
		GLVertex vertex = mWorld.addVertex(x, y, z);
		mVertexList.add(vertex);
		return vertex;
	}

	public void animateTransform(M4 transform) {
		mAnimateTransform = transform;
		
		if (mTransform != null)
			transform = mTransform.multiply(transform);

		Iterator<GLVertex> iter = mVertexList.iterator();
		while (iter.hasNext()) {
			GLVertex vertex = iter.next();
			mWorld.transformVertex(vertex, transform);
		}
	}
	
	public void startAnimation() {
	}

	public void endAnimation() {
		if (mTransform == null) {
			mTransform = new M4(mAnimateTransform);
		} else {
			mTransform = mTransform.multiply(mAnimateTransform);
		}
	}

	public M4						mTransform;
	public M4						mAnimateTransform;
	protected ArrayList<GLFace>		mFaceList = new ArrayList<GLFace>();
	protected ArrayList<GLVertex>	mVertexList = new ArrayList<GLVertex>();
	protected ArrayList<Integer>	mIndexList = new ArrayList<Integer>();	// make more efficient?
	protected GLWorld mWorld;
}