package rubiks.cs196;
/**
 * defines variables for colors, faces, orientations
 * defines basic methods done on cube array
 */

public class Cube {

	public static String completeCube = "GGGGGGGGGRRRRRRRRRBBBBBBBBBOOOOOOOOOWWWWWWWWWYYYYYYYYY";
	
	protected static char[] cube = "ZZZZGZZZZZZZZRZZZZZZZZBZZZZZZZZOZZZZZZZZWZZZZZZZZYZZZZ".toCharArray();
		
	protected static int size = cube.length;
	
	// orientation (used to employ algorithms relative to current orientation)
	protected static int orientation = 0;

	protected final static int GREEN = 0;
	protected final static int RED = 1;
	protected final static int BLUE = 2;
	protected final static int ORANGE = 3;
	protected final static int WHITE = 4;
	protected final static int YELLOW = 5;

	protected static int FRONT = 0;
	protected static int RIGHT = 1;
	protected static int BACK = 2;
	protected static int LEFT = 3;
	protected static int UP = 4;
	protected static int DOWN = 5;
	
	//reset the cube to complete configuration
	protected static void reset(){
		char[] newCube = { 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'G', 'R',
				'R', 'R', 'R', 'R', 'R', 'R', 'R', 'R', 'B', 'B', 'B', 'B', 'B',
				'B', 'B', 'B', 'B', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
				'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'Y', 'Y', 'Y', 'Y',
				'Y', 'Y', 'Y', 'Y', 'Y' };
		cube = newCube;
	}
	
	protected static void setTo(char[] newCube){
		cube = newCube;
	}
	
	// @return char color at @index
	protected static char getColor(int index) {
		if (cube[index] == 'Z')
			throw new RuntimeException("NO COLOR AT INDEX");
		return cube[index];
	}
	
	public static void setColor(int index, char color) {
		cube[index] = color;
	}
	
	public static boolean equals(String cube){
		return (cube.equals(completeCube));
	}

	// gives string representation of cube
	// @param cubeFormat
	// true: @return a string representation in blocks
	// false: @return a string representation in lists
	public static String toString(boolean format) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < size; i++) {
			buff.append(cube[i]);
			if (format) {
				buff.append(" ");
				if ((i + 1) % 3 == 0)
					buff.append("\n");
			} else {
				buff.append(", ");
			}
			if ((i + 1) % 9 == 0)
				buff.append("\n");
		}
		return buff.toString();
	}
	
	public static int getOrientation(){
		return orientation;
	}
	
	// changes orientation and relative values (Front, back, etc)
	public static void setOrientation(int orient) {
		if (orient<GREEN || orient >YELLOW)
			throw new RuntimeException("Impossible orientation");
		orientation = orient;
		switch (orientation) {
		case GREEN:
			FRONT = GREEN;
			RIGHT = RED;
			BACK = BLUE;
			LEFT = ORANGE;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case BLUE:
			FRONT = BLUE;
			RIGHT = ORANGE;
			BACK = GREEN;
			LEFT = RED;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case RED:
			FRONT = RED;
			RIGHT = BLUE;
			BACK = ORANGE;
			LEFT = GREEN;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case ORANGE:
			FRONT = ORANGE;
			RIGHT = GREEN;
			BACK = RED;
			LEFT = BLUE;
			UP = WHITE;
			DOWN = YELLOW;
			break;
		case WHITE:
			FRONT = WHITE;
			RIGHT = RED;
			BACK = YELLOW;
			LEFT = ORANGE;
			UP = BLUE;
			DOWN = GREEN;
			break;
		case YELLOW:
			FRONT = YELLOW;
			RIGHT = RED;
			BACK = WHITE;
			LEFT = ORANGE;
			UP = GREEN;
			DOWN = BLUE;
			break;
		}
	}
}