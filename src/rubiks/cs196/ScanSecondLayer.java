package rubiks.cs196;
public class ScanSecondLayer extends Scanner {

	// indicies used by methods

	private static int[] pairs = { 1, 4, 10, 13, 19, 22, 28, 31 };

	private static int[] topEdges = { 43, 41, 37, 39 };

	private static int[] centerPieces = { 4, 13, 22, 31 };

	private static int[][] secondLayer = { { 3, 5 }, { 12, 14 }, { 21, 23 },
			{ 30, 32 } };

	private static int[][] forceOut = { { 5, 12 }, { 14, 12 }, { 23, 30 },
			{ 32, 3 } };

	// contains whether pairs are equal for each face g, r, b, o
	private static boolean[] flags = new boolean[4];

	public static void run() {

		// base case
		if (sameFacesSecondLayer()) {
			new Message("All faces aligned!");
			return;
		}

		// ryanheise case 3
		int i = 0;
		while (i != -1) {
			i = forceOut();
			if (i != -1) {
				new Message("There is a piece you must force out.");
				Cube.setOrientation(i);
				Algorithms.secondLayer(3);
			}
		}

		//TextIO.putln(Cube.toString(true));
		
		// ryanheise case 1 and 2
		do {
			setFlags();
			alignTop();
			//TextIO.putln("aligned top");
			//TextIO.putln(Cube.toString(true));
			Cube.setOrientation(orient());
			if (sameFaces() > 1) {
				if (isWhite(topEdges[Cube.FRONT]))
					Cube.setOrientation(orientReverse());
			}
		} while (isWhite(topEdges[Cube.FRONT])); // if the corresponding top
													// edge cube is white, try
													// again
		if (isRight())
			Algorithms.secondLayer(1);
		else
			Algorithms.secondLayer(2);

		run();

	}

	private static void setFlags() {
		for (int i = 0, j = 0; i < pairs.length - 1; i += 2, j++) {
			flags[j] = equals(pairs[i], pairs[i + 1]);
		}
	}

	private static int sameFaces() {
		setFlags();
		int count = 0;
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				count++;
		}
		return count;
	}

	private static void alignTop() {
		do {
			Algorithms.secondLayer(4);
		} while (sameFaces() < 1);
		setFlags();
	}

	// orients front face to the face that has the pair
	private static int orient() {
		setFlags();
		for (int i = 0; i < flags.length; i++) {
			if (flags[i])
				return i;
		}
		return -1;
	}

	private static int orientReverse() {
		setFlags();
		for (int i = flags.length-1; i > -1; i--) {
			if (flags[i])
				return i;
		}
		return -1;
	}

	// ryanheise case1 is true, ryanheise case2 is false
	private static boolean isRight() {
		setFlags();
		return Cube.getColor(centerPieces[Cube.RIGHT]) == Cube
				.getColor(topEdges[Cube.FRONT]);
	}

	private static boolean isWhite(int i) {
		setFlags();
		return Cube.getColor(i) == 'W';
	}

	private static boolean sameFacesSecondLayer() {
		setFlags();
		for (int i = 0; i < secondLayer.length; i++) {
			char cubeLeft = Cube.getColor(secondLayer[i][0]);
			char cubeRight = Cube.getColor(secondLayer[i][1]);
			if (cubeLeft != cubeRight)
				return false;
		}
		return true;
	}

	// returns index of force out piece
	// if there is none, return -1
	private static int forceOut() {
		setFlags();
		for (int i = 0; i < forceOut.length; i++) {
			char cubeFront = Cube.getColor(forceOut[i][0]);
			char cubeRight = Cube.getColor(forceOut[i][1]);
			char centerFront = Cube.getColor(centerPieces[i]);
			char centerRight = Cube.getColor(centerPieces[(i + 1) % 4]);
			if (cubeFront == centerRight && cubeRight == centerFront)
				return i;
		}
		return -1;
	}
}
