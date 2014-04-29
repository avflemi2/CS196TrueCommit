package rubiks.cs196;
public class ScanTopCross extends Scanner {
	private static boolean[] whiteCross = new boolean[4];

	public static void run() {
		Cube.setOrientation(0);
		setFlags();
		if (correctFlags() == 4) {
			new Message(true,"All edges aligned!");
			return;
		}
		while (correctFlags() != 4) {
			placeWhiteCrossPieces();
		}
		new Message(true,"All edges aligned!");
	}

	public static void setFlags() {
		if (Cube.getColor(43) == 'W')
			whiteCross[0] = true;
		else
			whiteCross[0] = false;
		if (Cube.getColor(41) == 'W')
			whiteCross[1] = true;
		else
			whiteCross[1] = false;
		if (Cube.getColor(37) == 'W')
			whiteCross[2] = true;
		else
			whiteCross[2] = false;
		if (Cube.getColor(39) == 'W')
			whiteCross[3] = true;
		else
			whiteCross[3] = false;
	}

	public static int correctFlags() {
		int count = 0;
		for (int i = 0; i < whiteCross.length; i++) {
			if (whiteCross[i])
				count++;
		}
		return count;
	}

	public static boolean orientTop() {
		setFlags();
		int count = correctFlags();
		if (count == 0) {
			new Message(true,"Applying to case 1");
			return true;
		}
		if (count == 2) {
			new Message(true,"Applying to case 2");
			if (whiteCross[3] && (whiteCross[2] || whiteCross[1]))
				return true;
		}
		if (count == 4) {
			new Message(true,"Applying to case 3");
			return true;
		}
		return false;
	}

	public static void placeWhiteCrossPieces() {
		setFlags();
		int count = correctFlags();
		if (count == 4)
			return;
		while (!orientTop())
			Algorithms.makeEdgesFaceUp(1);
		Algorithms.makeEdgesFaceUp(2);
	}

}
