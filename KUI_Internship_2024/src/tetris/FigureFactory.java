package tetris;

public class FigureFactory {

	public static int[][] createNextFigure() {
		return new int[][] {
			{0, 1, 1, 0},
			{0, 1, 1, 0},
			{0, 0, 0, 0},
			{0, 0, 0, 0},
		};
	}

}
