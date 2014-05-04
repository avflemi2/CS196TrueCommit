package rubiks.cs196;

public class ErrorCheck extends Scanner {
	public static void errorCheck() {
		int[] colorCount = new int[6];
		String[] colors = { "Green", "Red", "Blue", "Orange", "White", "Yellow" };
		int[] corners = { 0, 2, 6, 8, 9, 11, 15, 17, 18, 20, 24, 26, 27, 29,
				33, 35, 36, 38, 42, 44, 45, 47, 51, 53 };
		int[] centers = { 4, 13, 22, 31, 40, 49 };
		int[] edges = { 1, 3, 5, 7, 10, 12, 14, 16, 19, 21, 23, 25, 28, 30, 32,
				34, 37, 39, 41, 43, 46, 48, 50, 52 };

		boolean isError = false;
		Message msg = new Message(false,
				"Cube compiled, but with these errors. please restart.\n");

		// Checks that there are nine of each color
		for (int i = 0; i < 54; i++) {
			char temp = Cube.getColor(i);
			if (temp == 'G')
				colorCount[0]++;
			else if (temp == 'R')
				colorCount[1]++;
			else if (temp == 'B')
				colorCount[2]++;
			else if (temp == 'O')
				colorCount[3]++;
			else if (temp == 'W')
				colorCount[4]++;
			else if (temp == 'Y')
				colorCount[5]++;
			else
				msg.append("Invalid color: " + temp);
			isError = true;
		}
		for (int i = 0; i < colorCount.length; i++) {
			if (colorCount[i] != 9)
				msg.append("Invalid number of " + colors[i] + " spaces");
			isError = true;
		}
		for (int i = 0; i < colorCount.length; i++) {
			colorCount[i] = 0;
		}

		// Checks that there are four of each corner color
		for (int i = 0; i < corners.length; i++) {
			char temp = Cube.getColor(corners[i]);
			if (temp == 'G')
				colorCount[0]++;
			else if (temp == 'R')
				colorCount[1]++;
			else if (temp == 'B')
				colorCount[2]++;
			else if (temp == 'O')
				colorCount[3]++;
			else if (temp == 'W')
				colorCount[4]++;
			else if (temp == 'Y')
				colorCount[5]++;
			else
				msg.append("Invalid color: " + temp);
			isError = true;
		}
		for (int i = 0; i < colorCount.length; i++) {
			if (colorCount[i] != 4)
				msg.append("Invalid number of " + colors[i] + " corner spaces");
			isError = true;

		}
		for (int i = 0; i < colorCount.length; i++) {
			colorCount[i] = 0;
		}

		// Checks that there is one of each center color
		for (int i = 0; i < centers.length; i++) {
			char temp = Cube.getColor(centers[i]);
			if (temp == 'G')
				colorCount[0]++;
			else if (temp == 'R')
				colorCount[1]++;
			else if (temp == 'B')
				colorCount[2]++;
			else if (temp == 'O')
				colorCount[3]++;
			else if (temp == 'W')
				colorCount[4]++;
			else if (temp == 'Y')
				colorCount[5]++;
			else
				msg.append("Invalid color: " + temp);
			isError = true;
		}
		for (int i = 0; i < colorCount.length; i++) {
			if (colorCount[i] != 1)
				msg.append("Invalid number of " + colors[i] + " center spaces");
			isError = true;
		}

		// Checks that there is one of each edge color
		for (int i = 0; i < colorCount.length; i++) {
			colorCount[i] = 0;
		}
		for (int i = 0; i < edges.length; i++) {
			char temp = Cube.getColor(edges[i]);
			if (temp == 'G')
				colorCount[0]++;
			else if (temp == 'R')
				colorCount[1]++;
			else if (temp == 'B')
				colorCount[2]++;
			else if (temp == 'O')
				colorCount[3]++;
			else if (temp == 'W')
				colorCount[4]++;
			else if (temp == 'Y')
				colorCount[5]++;
			else
				msg.append("Invalid color: " + temp);
			isError = true;
		}
		for (int i = 0; i < colorCount.length; i++) {
			if (colorCount[i] != 4)
				msg.append("Invalid number of " + colors[i] + " edge spaces");
			isError = true;
		}
		if (isError)
			msg.print();
	}
}
