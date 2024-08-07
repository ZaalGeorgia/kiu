package columns;

import java.util.Random;

class Figure {
	
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
	

	int x = Model.Width / 2 + 1, y = 1;
	
	private int c[] = new int[3];

	Figure() {
		x = Model.Width / 2 + 1;
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