package rubiks.cs196;
/**
 * Algorithms class contains algorithms: sets of permutations DONT FORGET TO SET
 * CUBE ORIENTATION BEFORE DOING ALGS
 */
public class Algorithms extends Permutation {

	// an algorithm - see ryanheise.com/cube/beginner.html ->
	// "Swap the incorrect cross pieces"
	public static void swapCrossPieces(int caseNum) {
		if (caseNum < 1 || caseNum > 3)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // adjacent faced pairs
			new Message(true,"First, we move one of the bad pieces to the top layer. This is so that we can move the top layer independently from the bottom layer. Then, we rotate the bad piece on the top layer until it becomes positioned directly above where we want it to go. Then we rotate it to the bottom layer which solves it. This very same move also moves the other bad piece to the top layer, and we solve it using the same strategy in reverse.");
			new Message(true,"Use Case 1");
			rotate180(RIGHT);
			rotateCW(UP);
			rotate180(FRONT);
			rotateCCW(UP);
			rotate180(RIGHT);
			break;
		case 2: // opposite faced pairs
			new Message(true,"First, we move one of the bad pieces to the top layer. This is so that we can move the top layer independently from the bottom layer. Then, we rotate the bad piece on the top layer until it becomes positioned directly above where we want it to go. Then we rotate it to the bottom layer which solves it. This very same move also moves the other bad piece to the top layer, and we solve it using the same strategy in reverse.");
			new Message(true,"Use Case 2");
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
			new Message(true,"A corner has already been inserted into the bottom layer the wrong way. Raise it to the top.");
			rotateCW(RIGHT);
			rotateCCW(UP);
			rotateCCW(RIGHT);
			break;
		case 2: // rotates top face once
			rotateCCW(UP);
			break;
		case 3:
			new Message(true,"Just twist the corner and it will match one of the other cases.");
			rotateCW(RIGHT);
			rotateCW(UP);
			rotateCCW(RIGHT);
			break;
		case 4:
			new Message(true,"Corner is ready to be inserted. Apply case 1.");
			rotateCCW(FRONT);
			rotateCCW(UP);
			rotateCW(FRONT);
			break;
		case 5:
			new Message(true,"Corner is ready to be inserted. Apply case 2.");
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
			new Message(true,"Case 1");
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
			new Message(true,"Case 2 (mirror of case 1)");
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
			new Message(true,"Case 3 (force out)");
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
