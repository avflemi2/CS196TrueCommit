package rubiks.cs196;

import android.content.Context;

public class solveCube {
	
	public static void run(Context cntxt) {
		//gets context of app that is using this class for Message
		
		
		new Message("Solving this cube:",cntxt);

		//COMMENT NEXT TWO LINES OUT IN ACTUAL CODE
		String stringCube = "YWYOGOGGBOGRGRBYRWBWWRBGRBGBBOWOWOOYOBWOWRGRBRYRYYYWYG";
		Cube.setTo(stringCube.toCharArray());
		new Message(Cube.toString(true),cntxt);

		new Message("STEP 2: SCANNING FOR CROSS PIECES",cntxt);
		ScanCrossPieces.run(cntxt);
		new Message("STEP 2: done",cntxt);

		new Message("STEP 3: SCANNING FOR BOTTOM CORNERS",cntxt);
		ScanBottomCorners.run(cntxt);
		new Message("STEP 3: done",cntxt);

		new Message("STEP 4: SCANNING FOR SECOND LAYER",cntxt);
		ScanSecondLayer.run(cntxt);
		new Message("STEP 4: done",cntxt);

		new Message("STEP 5: SCANNING FOR TOP CROSSPIECES",cntxt);
		ScanTopCross.run(cntxt);
		new Message("STEP 5: DONE",cntxt);

		new Message("STEP 6: SCANNING FOR TOP CORNERS",cntxt);
		ScanTopCornersUp.run(cntxt);
		new Message("STEP 6: DONE",cntxt);

		new Message("STEP 7: SCANNING SIDES OF TOP CORNERS",cntxt);
		ScanTopCornerSides.run(cntxt);
		new Message("STEP 7: DONE",cntxt);

		new Message("STEP 8: SCANNING FOR TOP EDGES",cntxt);
		ScanTopEdges.run(cntxt);
		new Message("STEP 8: DONE",cntxt);

		new Message(Cube.toString(true),cntxt);
		if (Cube.equals(Cube.completeCube))
			new Message("CUBE SOLVED!",cntxt);
	}

}
