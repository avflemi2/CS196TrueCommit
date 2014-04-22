package rubiks.cs196;

import com.threed.jpct.SimpleVector;

public class Cubelets {
	private static int i = 20; // scale
	private static SimpleVector[] coordinates = { new SimpleVector(-i, 0, 0),
			new SimpleVector(-i, i, i), new SimpleVector(-i, i, 0),
			new SimpleVector(-i, i, -i), new SimpleVector(-i, 0, -i),
			new SimpleVector(-i, -i, -i), new SimpleVector(-i, -i, 0),
			new SimpleVector(-i, -i, i), new SimpleVector(-i, 0, i),
			new SimpleVector(i, 0, 0), new SimpleVector(i, i, i),
			new SimpleVector(i, i, 0), new SimpleVector(i, i, -i),
			new SimpleVector(i, 0, -i), new SimpleVector(i, -i, -i),
			new SimpleVector(i, -i, 0), new SimpleVector(i, -i, i),
			new SimpleVector(i, 0, i), new SimpleVector(0, i, i),
			new SimpleVector(0, i, 0), new SimpleVector(0, i, -i),
			new SimpleVector(0, 0, -i), new SimpleVector(0, -i, -i),
			new SimpleVector(0, -i, 0), new SimpleVector(0, -i, i),
			new SimpleVector(0, 0, i) };
	public static int number = coordinates.length;
	
	//indexes of center cubies g, r, b, o, w, y
	private static int[] centerCubies = {26,10,22,1,24,20};
	private static int[][] faceCubies = { {} };

	public static SimpleVector getCoords(int i) {
		return coordinates[i];
	}
	
	
	public static void rotateCCW(int face){
		
	}
}