package solvethecube;
public class ScanTopCornersUp extends Scanner{
	private static boolean[] whiteCorners = new boolean[4];
	
	public static void run(){
		Cube.setOrientation(0);
		setFlags();
		if (correctFlags() == 4) {
			new Message(true,"All corners aligned!");
			return;
		}
		while (correctFlags() != 4) {
			placeTopCorners();
		}
		new Message(true,"All corners aligned!");
	}
	
	public static void setFlags(){
		if(Cube.getColor(44) == 'W') whiteCorners[0] = true;
		else whiteCorners[0] = false;
		if(Cube.getColor(38) == 'W') whiteCorners[1] = true;
		else whiteCorners[1] = false;
		if(Cube.getColor(36) == 'W') whiteCorners[2] = true;
		else whiteCorners[2] = false;
		if(Cube.getColor(42) == 'W') whiteCorners[3] = true;
		else whiteCorners[3] = false;
	}

	public static int correctFlags(){
		int count = 0;
		for(int i = 0; i < whiteCorners.length; i++){
			if(whiteCorners[i]) count++;
		}
		return count;
	}
	
	public static int orientTop(){
		setFlags();
		int count = correctFlags();
		if(count == 0){
			if(Cube.getColor(2) == 'W' && Cube.getColor(18) == 'W' && Cube.getColor(27) == 'W' && Cube.getColor(29) == 'W')
				return 1;
			if(Cube.getColor(9) == 'W' && Cube.getColor(11) == 'W' && Cube.getColor(27) == 'W' && Cube.getColor(29) == 'W')
				return 1;
		}
		if(count == 1){
			if(whiteCorners[3] && Cube.getColor(2) == 'W' && Cube.getColor(11) == 'W' && Cube.getColor(20) == 'W')
				return 1;
			if(whiteCorners[0] && Cube.getColor(0) == 'W' && Cube.getColor(27) == 'W' && Cube.getColor(18) == 'W')
				return 2;
		}
		if(count == 2){
			if(whiteCorners[1] && whiteCorners[2] && Cube.getColor(0) == 'W' && Cube.getColor(2) == 'W')
				return 1;
			if(whiteCorners[0] && whiteCorners[1] && Cube.getColor(0) == 'W' && Cube.getColor(20) == 'W')
				return 1;
			if(whiteCorners[0] && whiteCorners[3] && Cube.getColor(0) == 'W' && Cube.getColor(11) == 'W')
				return 1;
		}
		if(count == 4)
			return 0;
		return -1;
	}
	
	public static void placeTopCorners(){
		setFlags();
		int count = correctFlags();
		if(count == 4) return;
		while(orientTop() == -1)
			Algorithms.makeEdgesFaceUp(1);
		Algorithms.makeCornersFaceUp(orientTop());	
	}
}
