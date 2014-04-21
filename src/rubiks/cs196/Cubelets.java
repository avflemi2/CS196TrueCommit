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

	public static SimpleVector getCoords(int i) {
		return coordinates[i];
	}
	
	
	public static void rotateCCW(int face){
		
	}
}