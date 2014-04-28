package rubiks.cs196;
/**
 * Permutation class
 * contains methods to alter cube and also contains the cube array
 */

/**
 * code snippet so you don't have to type this all out again if you needed... {
 * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
 * 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
 * 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53 }
 */

public class Permutation extends Cube {

	public static int moves = 0;

	// permutations to rotate once clockwise
	// each of 6 permutations is an array that contains the addresses that the
	// color will go to. e.g. for the first perm array, rotate green, the color
	// at position 3 will be put into position 7 of the new cube
	public static final int[][] perm = {
			{ 6, 3, 0, 7, 4, 1, 8, 5, 2, 42, 10, 11, 43, 13, 14, 44, 16, 17,
					18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 45, 30, 31, 46,
					33, 34, 47, 36, 37, 38, 39, 40, 41, 35, 32, 29, 15, 12, 9,
					48, 49, 50, 51, 52, 53 }, // 0. green
			{ 0, 1, 47, 3, 4, 50, 6, 7, 53, 15, 12, 9, 16, 13, 10, 17, 14, 11,
					44, 19, 20, 41, 22, 23, 38, 25, 26, 27, 28, 29, 30, 31, 32,
					33, 34, 35, 36, 37, 2, 39, 40, 5, 42, 43, 8, 45, 46, 24,
					48, 49, 21, 51, 52, 18 }, // 1. red
			{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 53, 12, 13, 52, 15, 16, 51, 24,
					21, 18, 25, 22, 19, 26, 23, 20, 38, 28, 29, 37, 31, 32, 36,
					34, 35, 11, 14, 17, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48,
					49, 50, 27, 30, 33 }, // 2. blue
			{ 36, 1, 2, 39, 4, 5, 42, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
					18, 19, 51, 21, 22, 48, 24, 25, 45, 33, 30, 27, 34, 31, 28,
					35, 32, 29, 26, 37, 38, 23, 40, 41, 20, 43, 44, 0, 46, 47,
					3, 49, 50, 6, 52, 53 }, // 3. orange
			{ 9, 10, 11, 3, 4, 5, 6, 7, 8, 18, 19, 20, 12, 13, 14, 15, 16, 17,
					27, 28, 29, 21, 22, 23, 24, 25, 26, 0, 1, 2, 30, 31, 32,
					33, 34, 35, 42, 39, 36, 43, 40, 37, 44, 41, 38, 45, 46, 47,
					48, 49, 50, 51, 52, 53 }, // 4. white
			{ 0, 1, 2, 3, 4, 5, 33, 34, 35, 9, 10, 11, 12, 13, 14, 6, 7, 8, 18,
					19, 20, 21, 22, 23, 15, 16, 17, 27, 28, 29, 30, 31, 32, 24,
					25, 26, 36, 37, 38, 39, 40, 41, 42, 43, 44, 51, 48, 45, 52,
					49, 46, 53, 50, 47 }, // 5. yellow

	};
	public static int numFaces = perm.length;

	// constructor checks for errors in the perms and cube config and generates
	// error message
	public Permutation() {
		String failMsg = "";
		for (int i = 0; i < numFaces; i++) {
			int fail = checkPerms();
			if (fail != -1)
				failMsg += "face " + i + ", " + fail + "\n";
		}
		if (failMsg.length() > 0)
			TextIO.putln("perm duplicates at: " + failMsg);
	}

	// rotates @face counter-clockwise once
	protected static void rotateCCW2(int face) {
		char[] newCube = new char[size];
		for (int i = 0; i < size; i++) {
			// value in cube goes new address stated in perm
			newCube[perm[face][i]] = cube[i];
		}
		cube = newCube;
	}

	protected static void rotateCCW(int face) {
		new Message("CCW\t" + Cube.faceToString(face));
		moves++;
		rotateCCW2(face);
	}

	// rotates @face clockwise once
	protected static void rotateCW(int face) {
		new Message("CW\t" + Cube.faceToString(face));
		moves++;
		rotateCCW2(face);
		rotateCCW2(face);
		rotateCCW2(face);
	}

	// rotates @face clockwise twice
	protected static void rotate180(int face) {
		new Message("180\t" + Cube.faceToString(face));
		moves++;
		rotateCCW2(face);
		rotateCCW2(face);
	}

	// finds duplicate permutation values
	// @return -1 if no duplicates, else @return index of first duplicate
	public static int checkPerms() {
		for (int i = 0; i < numFaces; i++) {
			for (int j = 0; j < size; j++) {
				int compare = perm[i][j];
				for (int k = 0; k < size; k++) {
					if (j != k) {
						if (compare == perm[i][k])
							return k;
					}
				}
			}
		}
		return -1;
	}
}
