package rubiks.cs196;

import android.content.Context;

public class ScanTopEdges extends Scanner {

	public static int[] topLayerCenter = { 1, 10, 19, 28 };
	private static int[] centerPieces = { 4, 13, 22, 31 };

	public static boolean[] flags = new boolean[4];

	public static void run(Context cntxt) {
		setFlags();

		// base case
		if (countFlags() == 4) // FINISHED
			return;

		if (countFlags() == 0) { // ryanheise case 3
			Algorithms.makeCornersFaceUp(1);
			Cube.setOrientation(Cube.RIGHT);
			Algorithms.makeCornersFaceUp(2);
		}
		
		if (countFlags() == 1) {
			Cube.setOrientation(orient());
			if (isClockwise()) { // ryanheise case 1
				Algorithms.makeCornersFaceUp(1);
				Cube.setOrientation(Cube.RIGHT);
				Algorithms.makeCornersFaceUp(2);
			}

			else { // ryanheise case 2
				Algorithms.makeCornersFaceUp(2);
				Cube.setOrientation(Cube.LEFT);
				Algorithms.makeCornersFaceUp(1);
			}
		}

		run(cntxt);
	}

	public static void setFlags() {
		for (int i = 0; i < flags.length; i++) {
			char col1 = Cube.getColor(topLayerCenter[i]);
			char col2 = Cube.getColor(centerPieces[i]);
			flags[i] = (col1 == col2);
		}
	}

	public static boolean isSolved() {
		for (int i = 0; i < flags.length; i++) {
			if (!flags[i])
				return false;
		}
		return true;
	}

	public static int countFlags() {
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				count++;
		}
		return count;
	}

	// returns orientation
	public static int orient() {
		for (int i = 0; i < flags.length; i++) {
			if (flags[i] == true)
				return (i + 2) % 4; // opposite of complete face
		}
		return -1;
	}

	public static boolean isClockwise() {
		char cube1 = Cube.getColor(centerPieces[Cube.FRONT]);
		char cube2 = Cube.getColor(topLayerCenter[Cube.RIGHT]);
		return cube1 == cube2;
	}
}