package solvethecube;

public class Scanner {	
	public static boolean equals(int index1, int index2) {
		char top = Cube.getColor(index1);
		char bot = Cube.getColor(index2);
		return (top == bot);
	}
}
