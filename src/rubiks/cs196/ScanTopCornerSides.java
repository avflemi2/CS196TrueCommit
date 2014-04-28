package rubiks.cs196;
public class ScanTopCornerSides extends Scanner{
	private static boolean[] whiteCorners = new boolean[4];
	
	public static void run(){
		Cube.setOrientation(0);
		setFlags();
		if (correctFlags() == 4) {
			new Message("All corners aligned!");
			return;
		}
		while (correctFlags() != 4) {
			placeTopCorners();
		}
		new Message("All corners aligned!");
	}
	
	public static void setFlags(){
		if(Cube.getColor(2) == 'G' && Cube.getColor(9) == 'R') whiteCorners[1] = true;
		else whiteCorners[1] = false;
		if(Cube.getColor(11) == 'R' && Cube.getColor(18) == 'B') whiteCorners[2] = true;
		else whiteCorners[2] = false;
		if(Cube.getColor(20) == 'B' && Cube.getColor(27) == 'O') whiteCorners[3] = true;
		else whiteCorners[3] = false;
		if(Cube.getColor(29) == 'O' && Cube.getColor(0) == 'G') whiteCorners[0] = true;
		else whiteCorners[0] = false;
	}

	public static int correctFlags(){
		setFlags();
		int count = 0;
		for(int i = 0; i < whiteCorners.length; i++){
			if(whiteCorners[i]) count++;
		}
		return count;
	}
	
	public static int orientTop(){
		setFlags();
		int count = correctFlags();
		if(whiteCorners[0] && (Cube.getColor(18) == Cube.getColor(20))){
			Cube.setOrientation(0);
			return 1;
		}
		if(whiteCorners[1] && (Cube.getColor(18) == Cube.getColor(20))){
			Cube.setOrientation(0);
			return 2;
		}
		if(whiteCorners[1] && (Cube.getColor(27) == Cube.getColor(29))){
			Cube.setOrientation(1);
			return 1;
		}
		if(whiteCorners[2] && (Cube.getColor(27) == Cube.getColor(29))){
			Cube.setOrientation(1);
			return 2;
		}
		if(whiteCorners[2] && (Cube.getColor(0) == Cube.getColor(2))){
			Cube.setOrientation(2);
			return 1;
		}
		if(whiteCorners[3] && (Cube.getColor(0) == Cube.getColor(2))){
			Cube.setOrientation(2);
			return 2;
		}
		if(whiteCorners[3] && (Cube.getColor(9) == Cube.getColor(11))){
			Cube.setOrientation(3);
			return 1;
		}
		if(whiteCorners[0] && (Cube.getColor(9) == Cube.getColor(11))){
			Cube.setOrientation(3);
			return 2;
		}
		
		if(whiteCorners[1] && count >= 2){
			Cube.setOrientation(0);
			return 1;
		}
		if(whiteCorners[2] && count >= 2){
			Cube.setOrientation(1);
			return 1;
		}
		if(whiteCorners[3] && count >= 2){
			Cube.setOrientation(2);
			return 1;
		}
		if(whiteCorners[0] && count >= 2){
			Cube.setOrientation(3);
			return 1;
		}
		return 3;
			
	}
	
	public static void placeTopCorners(){
		setFlags();
		int count = correctFlags();
		if(count == 4) return;
		while(orientTop() == 3)
			Algorithms.positionCorners(3);
		Algorithms.positionCorners(orientTop());
		
	}
}
