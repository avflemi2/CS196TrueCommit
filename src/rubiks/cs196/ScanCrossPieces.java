package rubiks.cs196;

import android.content.Context;

public class ScanCrossPieces extends Scanner {

	private static int[] pairs = { 4, 7, 13, 16, 22, 25, 31, 34 };

	// contains whether pairs are equal for each face g, r, b, o
	private static boolean[] flags = new boolean[4];

	// run the method
	public static void run(Context cntxt) {
		setFlags();
		if (sameFaces() == 4) {
			new Message("All faces aligned!",cntxt);
			return;
		}
		new Message("Rotate the yellow cross until some of the colours "
				+ "around the sides begin to match. If you get it so "
				+ "that one colour matches, keep rotating futher. "
				+ "It is always possible to get at least 2 colours "
				+ "to match",cntxt);
		alignBottom();
		if (isAdjacent()) {
			Cube.setOrientation(orientAdjacent());
			Algorithms.swapCrossPieces(1);
		} else {
			Cube.setOrientation(orientOpposite());
			Algorithms.swapCrossPieces(2);
		}
	}

	private static void setFlags() {
		for (int i = 0, j = 0; i < pairs.length - 1; i += 2, j++) {
			flags[j] = equals(pairs[i], pairs[i + 1]);
		}
	}

	// returns number of faces that have pairs
	private static int sameFaces() {
		setFlags();
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				count++;
		}
		return count;
	}

	private static void alignBottom() {
		setFlags();
		while (sameFaces() < 2) {
			Algorithms.swapCrossPieces(3);
		}
	}

	// returns face that will set orientation
	private static int orientAdjacent() {
		setFlags();
		if (!flags[0] && !flags[3])
			return 3;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}

	private static boolean isAdjacent() {
		setFlags();
		for (int i = 0; i < flags.length - 1; i++) {
			if (flags[i] && flags[i + 1])
				return true;
		}
		return false;
	}

	public static int orientOpposite() {
		setFlags();
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}
}