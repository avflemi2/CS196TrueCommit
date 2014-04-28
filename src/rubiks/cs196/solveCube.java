package rubiks.cs196;

import android.os.Looper;

public class solveCube {

	/**
	 * call scanners and prints here
	 * **/
	public static void main(String[] args) {

		Looper.prepare();

		new Message("The first step was too build a yellow cross. But "
				+ "ran out of time to implement it :)\n");
		
		new Message("Solving this cube:\n");

		String stringCube = "BWWBGRBOGRBGBRORGORROGBGWBYYGOROWRROGWWWWOYOBWYYYYYBYG";
		Cube.setTo(stringCube.toCharArray());
		new Message(Cube.toString(true));

		ErrorCheck.errorCheck();

		new Message("STEP 2: Swap the incorrect cross pieces\n");
		new Message("Rotate the yellow cross until some of the colours "
				+ "around the sides begin to match. If you get it so "
				+ "that one colour matches, keep rotating futher. It "
				+ "is always possible to get at least 2 colours to match. "
				+ "If you're very lucky, it is possible "
				+ "that all 4 colours match.\n");
		ScanCrossPieces.run();
		new Message("STEP 2: DONE");

		new Message("STEP 3: Insert the 4 bottom corners");
		new Message("Next, you will insert the 4 yellow corner pieces into the bottom layer.");
		ScanBottomCorners.run();
		new Message("STEP 3: DONE");

		new Message("STEP 4: Insert the 4 middle edges");
		ScanSecondLayer.run();
		new Message("STEP 4: DONE");

		new Message("STEP 5: Make the edges face up");
		ScanTopCross.run();
		new Message("STEP 5: DONE");

		new Message("STEP 6: Make the corners face up");
		ScanTopCornersUp.run();
		new Message("STEP 6: DONE");

		new Message("STEP 7: Correctly position the corners");
		ScanTopCornerSides.run();
		new Message("STEP 7: DONE");

		new Message("STEP 8: Correctly position the edges");
		ScanTopEdges.run();
		new Message("STEP 8: DONE");

		TextIO.putln(Cube.toString(true));
		if (Cube.equals(Cube.completeCube))
			new Message("CUBE SOLVED IN " + Permutation.moves + " MOVES!");
		else
			new Message("Failed");
	}
}
