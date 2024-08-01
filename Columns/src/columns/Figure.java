package columns;

import java.util.Arrays;
import java.util.Random;

class Figure {
	static int x = Columns.Width / 2 + 1, y = 1;
	static Random r = new Random();

	static void rotateArraysElementsLeft(int[] c) {
		int i = c[0];
		c[0] = c[1];
		c[1] = c[2];
		c[2] = i;
	}

	static void rotateArraysElementsRight(int[] c) {
		int i = c[0];
		c[0] = c[2];
		c[2] = c[1];
		c[1] = i;
	}
	
//	private static void rotateElements(int[] data, int direction) {
//		int i = data[1 + direction];
//		data[0] = data[(0 + direction + 3) % 3];
//		data[1] = data[(1 + direction + 3) % 3];
//		data[2] = data[(2 + direction + 3) % 3];
//		data[1 - direction] = i;
//	}
//	
	private int c[] = new int[3];

	Figure() {
		x = Columns.Width / 2 + 1;
		y = 1;
		c[0] = (int) (Math.abs(r.nextInt()) % 7 + 1);
		c[1] = (int) (Math.abs(r.nextInt()) % 7 + 1);
		c[2] = (int) (Math.abs(r.nextInt()) % 7 + 1);
	}

	void rotateFigureCellsRight() {
		int i = c[0];
		c[0] = c[2];
		c[2] = c[1];
		c[1] = i;
	}

	void rotateFigureCellsLeft() {
		Figure.rotateArraysElementsLeft(c);
	}

	public int[] getCells() {
		return c;
	}

}