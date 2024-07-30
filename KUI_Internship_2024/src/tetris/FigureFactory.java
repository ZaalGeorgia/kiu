package tetris;

public class FigureFactory {

	public static int[][] createNextFigure() {
		return O();
	}

	static int[][] O() {
		return new int[][] {
			{0, 1, 1, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
		};
	}

	static int[][] J() {
		return new int[][] {
			{0, 0, 2, 0},
			{0, 0, 2, 0},
			{0, 2, 2, 0},
			{0, 0, 0, 0},
		};
	}
	
	static int[][] rotatedJ() {
		return new int[][] {
			{0, 0, 0, 0},
			{0, 2, 0, 0},
			{0, 2, 2, 2},
			{0, 0, 0, 0},
		};
	}
	
}
