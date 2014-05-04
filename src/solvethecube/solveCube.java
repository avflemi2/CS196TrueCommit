package solvethecube;

import android.os.Looper;

public class solveCube {

	public static void main() {

		// for thread
		Looper.prepare();

		ErrorCheck.errorCheck();
		// ScanTest.run();

		new Message(true, "STEP 1: The first step was to build a yellow"
				+ " cross. You should have been able to do this on "
				+ "your own :)\n");
		new Message(true, "STEP 2: Swap the incorrect cross pieces\n");
		ScanCrossPieces.run();
		new Message(true, "STEP 3: Insert the 4 bottom corners");
		ScanBottomCorners.run();
		new Message(true, "STEP 4: Insert the 4 middle edges");
		ScanSecondLayer.run();
		new Message(true, "STEP 5: Make the edges face up");
		ScanTopCross.run();
		new Message(true, "STEP 6: Make the corners face up");
		ScanTopCornersUp.run();
		new Message(true, "STEP 7: Correctly position the corners");
		ScanTopCornerSides.run();
		new Message(true, "STEP 8: Correctly position the edges");
		ScanTopEdges.run();

		TextIO.putln(Cube.toString(true));
		if (Cube.equals(Cube.completeCube))
			new Message(true, "CUBE SOLVED IN " + Permutation.moves + " MOVES!");
		else
			new Message(true, "Failed");
	}
}
