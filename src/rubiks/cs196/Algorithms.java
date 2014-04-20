package rubiks.cs196;

import android.content.Context;

/**
 * Algorithms class contains algorithms: sets of permutations DONT FORGET TO SET
 * CUBE ORIENTATION BEFORE DOING ALGS
 */
public class Algorithms extends Permutation {

	public Algorithms(Context cntxt) {
		super(cntxt);
		// TODO Auto-generated constructor stub
	}

	// an algorithm - see ryanheise.com/cube/beginner.html ->
	// "Swap the incorrect cross pieces"
	public static void swapCrossPieces(int caseNum) {
		if (caseNum < 1 || caseNum > 3)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // adjacent faced pairs
			rotate180(RIGHT);
			rotateCW(UP);
			rotate180(FRONT);
			rotateCCW(UP);
			rotate180(RIGHT);
			break;
		case 2: // opposite faced pairs
			rotate180(RIGHT);
			rotate180(UP);
			rotate180(LEFT);
			rotate180(UP);
			rotate180(RIGHT);
			break;
		case 3: // rotate bottom face to match pairs initially
			rotateCW(DOWN);
			break;
		}
	}

	public static void insertBottomCorners(int caseNum) {
		if (caseNum < 1 || caseNum > 5) {
			throw new RuntimeException("Invalid case number " + caseNum);
		}
		switch (caseNum) {
		case 1: // yellow piece is in bottom layer, bring it up top
			rotateCW(RIGHT);
			rotateCCW(UP);
			rotateCCW(RIGHT);
			break;
		case 2: // rotates top face once
			rotateCCW(UP);
			break;
		case 3:
			rotateCW(RIGHT);
			rotateCW(UP);
			rotateCCW(RIGHT);
			break;
		case 4:
			rotateCCW(FRONT);
			rotateCCW(UP);
			rotateCW(FRONT);
			break;
		case 5:
			rotateCW(RIGHT);
			rotateCCW(UP);
			rotateCCW(RIGHT);
			rotate180(UP);
			break;
		}
	}

	public static void secondLayer(int caseNum) {
		if (caseNum < 1 || caseNum > 4)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // ryanheise case 1
			rotateCW(UP);
			rotateCW(RIGHT);
			rotateCCW(UP);
			rotateCCW(RIGHT);
			rotateCCW(UP);
			rotateCCW(FRONT);
			rotateCW(UP);
			rotateCW(FRONT);
			break;
		case 2: // mirror case of 1
			rotateCCW(UP);
			rotateCCW(LEFT);
			rotateCW(UP);
			rotateCW(LEFT);
			rotateCW(UP);
			rotateCW(FRONT);
			rotateCCW(UP);
			rotateCCW(FRONT);
			break;
		case 3: // "force out" the piece
			// this is equal to case 1 OR 2, doesn't need to be called
			rotateCCW(UP);
			rotateCCW(FRONT);
			rotateCW(UP);
			rotateCW(FRONT);
			rotateCW(UP);
			rotateCW(RIGHT);
			rotateCCW(UP);
			rotateCCW(RIGHT);
			break;
		case 4: //rotates top till matches
			rotateCW(UP);
		}
	}

	public static void makeEdgesFaceUp(int caseNum) {
		if (caseNum < 1 || caseNum > 2)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // used to rotate top to get ryanheise case 1, 2, or 3
			rotateCW(UP);
			break;
		// all ryanheise cases use this same alg on front face
		case 2:
			rotateCCW(RIGHT);
			rotateCCW(UP);
			rotateCCW(FRONT);
			rotateCW(UP);
			rotateCW(FRONT);
			rotateCW(RIGHT);
			break;
		}
	}

	public static void makeCornersFaceUp(int caseNum) {
		if (caseNum < 1 || caseNum > 2)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // used in ryanheise cases 3-7
			rotateCW(RIGHT);
			rotateCW(UP);
			rotateCCW(RIGHT);
			rotateCW(UP);
			rotateCW(RIGHT);
			rotate180(UP);
			rotateCCW(RIGHT);
			break;
		case 2: // mirror of case 1 (FRONT IS GREEN)
			rotateCCW(LEFT);
			rotateCCW(UP);
			rotateCW(LEFT);
			rotateCCW(UP);
			rotateCCW(LEFT);
			rotate180(UP);
			rotateCW(LEFT);
			break;
		}
	}

	public static void positionCorners(int caseNum) {
		if (caseNum < 1 || caseNum > 3)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // used in ryanheise cases 1,4
			rotateCCW(RIGHT);
			rotateCW(FRONT);
			rotateCCW(RIGHT);
			rotate180(BACK);
			rotateCW(RIGHT);
			rotateCCW(FRONT);
			rotateCCW(RIGHT);
			rotate180(BACK);
			rotate180(RIGHT);
			break;
		case 2: // mirror of case 1 (FRONT IS GREEN)
			rotateCW(LEFT);
			rotateCCW(FRONT);
			rotateCW(LEFT);
			rotate180(BACK);
			rotateCCW(LEFT);
			rotateCW(FRONT);
			rotateCW(LEFT);
			rotate180(BACK);
			rotate180(LEFT);
			break;
		case 3: // ryanheise case 3 rotates top
			rotateCW(UP);
			break;
		}
	}

}
