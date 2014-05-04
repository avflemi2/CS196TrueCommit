package rubiks.cs196;

public class ScanCrossPieces extends Scanner {

	private static int[] pairs = { 4, 7, 13, 16, 22, 25, 31, 34 };

	// contains whether pairs are equal for each face g, r, b, o
	private static boolean[] flags = new boolean[4];

	// run the method
	public static void run() {
		new Message(true, "You will rotate the yellow cross until some of"
				+ " the colors "
				+ "around the sides begin to match. If you get it so "
				+ "that one color matches, keep rotating futher. It "
				+ "is always possible to get at least 2 colors to match. "
				+ "If you're very lucky, it is possible "
				+ "that all 4 colors match.\n");
		setFlags();
		if (sameFaces() == 4) {
			new Message(true, "All 4 colors match!");
			return;
		}
		new Message(true,
				"Rotate the yellow cross until you get two colors to match.");
		alignBottom();
		if (sameFaces() == 4) {
			new Message(true, "All 4 colors match!");
			return;
		}
		new Message(true, "You have two bad cross pieces. "
				+ "You will need to swap them. There are "
				+ "two different possibilities. Either the "
				+ "two bad pieces are next to each other, "
				+ "or they are on opposite sides of the cube.");
		if (isAdjacent()) {
			new Message(true, "Your two bad pieces are next to " + "eachother.");
			Cube.setOrientation(orientAdjacent());
			Algorithms.swapCrossPieces(1);
		} else {
			new Message(true, "Your two bad pieces are next to "
					+ "on opposite sides of one another.");
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
		new Message(true, "Two colors match!");
	}

	// returns face that will set orientation
	private static int orientAdjacent() {
		setFlags();
		if (!flags[0] && !flags[3])
			return 3;
		for (int i = 0; i < flags.length; i++) {
			if (!flags[i])
				return i;
		}
		return -1;
	}

	private static boolean isAdjacent() {
		setFlags();
		for (int i = 0; i < flags.length - 1; i++) {
			if ((flags[i] && flags[i + 1]) || (flags[0] && flags[3]))
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
