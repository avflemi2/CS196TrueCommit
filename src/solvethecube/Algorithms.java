package solvethecube;
/**
 * Algorithms class contains algorithms: sets of permutations DONT FORGET TO SET
 * CUBE ORIENTATION BEFORE DOING ALGS
 */
public class Algorithms extends Permutation {

	static Message msg = null;
	
	// an algorithm - see ryanheise.com/cube/beginner.html ->
	// "Swap the incorrect cross pieces"
	public static void swapCrossPieces(int caseNum) {
		if (caseNum < 1 || caseNum > 3)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // adjacent faced pairs
			new Message(true,"First, we move one of the bad pieces to the top layer. This is so that we can move the top layer independently from the bottom layer. Then, we rotate the bad piece on the top layer until it becomes positioned directly above where we want it to go. Then we rotate it to the bottom layer which solves it. This very same move also moves the other bad piece to the top layer, and we solve it using the same strategy in reverse.");
			msg = new Message(false,"Apply case 1:");
			msg.append(rotate180(RIGHT));
			msg.append(rotateCW(UP));
			msg.append(rotate180(FRONT));
			msg.append(rotateCCW(UP));
			msg.append(rotate180(RIGHT));
			msg.print();
			break;
		case 2: // opposite faced pairs
			new Message(true,"First, we move one of the bad pieces to the top layer. This is so that we can move the top layer independently from the bottom layer. Then, we rotate the bad piece on the top layer until it becomes positioned directly above where we want it to go. Then we rotate it to the bottom layer which solves it. This very same move also moves the other bad piece to the top layer, and we solve it using the same strategy in reverse.");
			msg = new Message(false,"Apply case 2");
			msg.append(rotate180(RIGHT));
			msg.append(rotate180(UP));
			msg.append(rotate180(LEFT));
			msg.append(rotate180(UP));
			msg.append(rotate180(RIGHT));
			msg.print();
			break;
		case 3: // rotate bottom face to match pairs initially
			msg = new Message(false,"Rotate the bottom face to match pairs:");
			msg.append(rotateCW(DOWN));
			msg.print();
			break;
		}
	}

	public static void insertBottomCorners(int caseNum) {
		if (caseNum < 1 || caseNum > 5) {
			throw new RuntimeException("Invalid case number " + caseNum);
		}
		switch (caseNum) {
		case 1: // yellow piece is in bottom layer, bring it up top
			msg = new Message(false,"A corner has already been inserted into the bottom layer the wrong way. Raise it to the top.");
			msg.append(rotateCW(RIGHT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(RIGHT));
			msg.print();
			break;
		case 2: // rotates top face once
			msg = new Message(false,"Rotate the top face once:");
			msg.append(rotateCCW(UP));
			msg.print();
			break;
		case 3:
			msg = new Message(false,"Corner is ready to be inserted. Apply case 1.");
			msg.append(rotateCW(RIGHT));
			msg.append(rotateCW(UP));
			msg.append(rotateCCW(RIGHT));
			msg.print();
			break;
		case 4:
			msg = new Message(false,"Corner is ready to be inserted. Apply case 2.");
			msg.append(rotateCCW(FRONT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCW(FRONT));
			msg.print();
			break;
		case 5:
			msg = new Message(false,"Just twist the corner and it will match one of the other cases.");
			msg.append(rotateCW(RIGHT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(RIGHT));
			msg.append(rotate180(UP));
			msg.print();
			break;
		}
	}

	public static void secondLayer(int caseNum) {
		if (caseNum < 1 || caseNum > 4)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // ryanheise case 1
			msg = new Message(false,"Apply case 1:");
			msg.append(rotateCW(UP));
			msg.append(rotateCW(RIGHT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(RIGHT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(FRONT));
			msg.append(rotateCW(UP));
			msg.append(rotateCW(FRONT));
			msg.print();
			break;
		case 2: // mirror case of 1
			msg = new Message(false,"Apply case 2 (mirror of case 1):");
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(LEFT));
			msg.append(rotateCW(UP));
			msg.append(rotateCW(LEFT));
			msg.append(rotateCW(UP));
			msg.append(rotateCW(FRONT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(FRONT));
			msg.print();
			break;
		case 3: // "force out" the piece
			// this is equal to case 1
			msg = new Message(false,"Apply case 3 to force out the piece:");
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(FRONT));
			msg.append(rotateCW(UP));
			msg.append(rotateCW(FRONT));
			msg.append(rotateCW(UP));
			msg.append(rotateCW(RIGHT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(RIGHT));
			msg.print();
			break;
		case 4: //rotates top till matches
			msg = new Message(false,"Rotate the top until it matches:");
			msg.append(rotateCW(UP));
			msg.print();
		}
	}

	public static void makeEdgesFaceUp(int caseNum) {
		if (caseNum < 1 || caseNum > 2)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // used to rotate top to get ryanheise case 1, 2, or 3
			msg = new Message(false,"Rotate the top until you get case 1, 2, or 3:");
			msg.append(rotateCW(UP));
			msg.print();
			break;
		// all ryanheise cases use this same alg on front face
		case 2:
			msg = new Message(false,"Apply this magic algorithm to make the edges face up:");
			msg.append(rotateCCW(RIGHT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(FRONT));
			msg.append(rotateCW(UP));
			msg.append(rotateCW(FRONT));
			msg.append(rotateCW(RIGHT));
			msg.print();
			break;
		}
	}

	public static void makeCornersFaceUp(int caseNum) {
		if (caseNum < 1 || caseNum > 2)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // used in ryanheise cases 3-7
			msg = new Message(false,"Apply case 1:");
			msg.append(rotateCW(RIGHT));
			msg.append(rotateCW(UP));
			msg.append(rotateCCW(RIGHT));
			msg.append(rotateCW(UP));
			msg.append(rotateCW(RIGHT));
			msg.append(rotate180(UP));
			msg.append(rotateCCW(RIGHT));
			msg.print();
			break;
		case 2: // mirror of case 1 (FRONT IS GREEN)
			msg = new Message(false,"Apply case 2 (mirror of case 1):");
			msg.append(rotateCCW(LEFT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCW(LEFT));
			msg.append(rotateCCW(UP));
			msg.append(rotateCCW(LEFT));
			msg.append(rotate180(UP));
			msg.append(rotateCW(LEFT));
			msg.print();
			break;
		}
	}

	public static void positionCorners(int caseNum) {
		if (caseNum < 1 || caseNum > 3)
			throw new RuntimeException("Invalid case number " + caseNum);
		switch (caseNum) {
		case 1: // used in ryanheise cases 1,4
			msg = new Message(false,"Apply case 1:");
			msg.append(rotateCCW(RIGHT));
			msg.append(rotateCW(FRONT));
			msg.append(rotateCCW(RIGHT));
			msg.append(rotate180(BACK));
			msg.append(rotateCW(RIGHT));
			msg.append(rotateCCW(FRONT));
			msg.append(rotateCCW(RIGHT));
			msg.append(rotate180(BACK));
			msg.append(rotate180(RIGHT));
			msg.print();
			break;
		case 2: // mirror of case 1 (FRONT IS GREEN)
			msg = new Message(false,"Apply case 2 (mirror of case 1):");
			msg.append(rotateCW(LEFT));
			msg.append(rotateCCW(FRONT));
			msg.append(rotateCW(LEFT));
			msg.append(rotate180(BACK));
			msg.append(rotateCCW(LEFT));
			msg.append(rotateCW(FRONT));
			msg.append(rotateCW(LEFT));
			msg.append(rotate180(BACK));
			msg.append(rotate180(LEFT));
			msg.print();
			break;
		case 3: // ryanheise case 3 rotates top
			msg = new Message(false,"Rotate the top face until it matches one of the previous cases:");
			msg.append(rotateCW(UP));
			msg.print();
			break;
		}
	}

}
