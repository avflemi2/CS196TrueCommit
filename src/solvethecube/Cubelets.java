package solvethecube;

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

	// indexes of center cubies g, r, b, o, w, y
	public static int[] centerCubies = { 25, 9, 21, 0, 23, 19 };
	// indexes of connected cubies of faces (minus center cubies) g, r, b, o, w,
	// y
	public static int[][] faceCubies = { { 7, 24, 16, 8, 17, 1, 18, 10 },
			{ 16, 15, 14, 17, 13, 10, 11, 12 },
			{ 14, 22, 5, 13, 4, 12, 20, 3 }, { 5, 6, 7, 4, 8, 3, 2, 1 },
			{ 5, 22, 14, 6, 15, 7, 24, 16 },
			{ 1, 18, 10, 2, 11, 3, 20, 12 } };

	public static SimpleVector getCoords(int i) {
		return coordinates[i];
	}
}