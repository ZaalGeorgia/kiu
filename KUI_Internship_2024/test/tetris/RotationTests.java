package tetris;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotationTests {

	@Test
	public void test() {
		var model = new TetrisModel(TetrisModel.DEFAULT_WIDTH, TetrisModel.DEFAULT_HEIGHT, TetrisModel.DEFAULT_COLORS_NUMBER);
		model.figure = FigureFactory.J();
		model.rotate();
		var rotatedJ = FigureFactory.rotatedJ();
		for (int i = 0; i < rotatedJ.length; i++) {
			assertArrayEquals(model.figure[i], rotatedJ[i ]);
		}
	}

}
