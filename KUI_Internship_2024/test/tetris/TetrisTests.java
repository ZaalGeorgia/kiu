package tetris;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TetrisTests {

	private TetrisModel model;
	
	@Before
	public void setup() {
		model = new TetrisModel(TetrisModel.DEFAULT_WIDTH, TetrisModel.DEFAULT_HEIGHT, TetrisModel.DEFAULT_COLORS_NUMBER);
	}

	@Test
	public void testCreationOfModel() {
		Pair p = model.size();
		assertEquals(TetrisModel.DEFAULT_WIDTH, p.x());
		assertEquals(TetrisModel.DEFAULT_HEIGHT, p.y());
		testFieldExsistence();
	}

	@Test
	public void testFieldExsistence() {
		int[][] field = model.state.field;
		assertNotNull(field);
		assertEquals(TetrisModel.DEFAULT_HEIGHT, field.length);
	}
	
	@Test
	public void testColorsRange() throws Exception {
		assertEquals(TetrisModel.DEFAULT_COLORS_NUMBER, model.maxColors);
	}

	@Test
	public void testFigureCreated() throws Exception {
		int[][] figure = model.state.figure;
		assertNotNull(figure);
	}
	
	@Test
	public void positionExists() throws Exception {
		Pair p = model.state.position;
		assertNotNull(p);
		assertEquals(0, p.y());
		assertEquals(model.size().x() / 2 - 2, p.x());
	}
	
	@Test
	public void testGameEventsListener() throws Exception {
		assertTrue(GameEventsListener.class.isAssignableFrom(model.getClass()));
	}
	
	@Test
	public void testSlideDown() throws Exception {
		int old = model.state.position.y();
		model.slideDown();
		assertEquals(old + 1, model.state.position.y());
	}
	
	@Test
	public void testFigureNotOverlapsFieldCellsAfterSlidingDown() throws Exception {
		model.state.field[2][model.size().x()/2] = 1;
		boolean valid = model.isNewFiguresPositionValid(new Pair(model.state.position.x(), model.state.position.y() + 1));
		assertFalse(valid);
	}
	
	@Test
	public void testPasteFigure() throws Exception {
		model.pasteFigure();
		assertEquals(1, model.state.field[0][model.size().x()/2-1]);
		assertEquals(1, model.state.field[0][model.size().x()/2]);
		assertEquals(1, model.state.field[1][model.size().x()/2-1]);
		assertEquals(1, model.state.field[1][model.size().x()/2]);
	}
	
	@Test
	public void testMoveLeft() throws Exception {
		var oldPos = model.state.position;
		model.moveLeft();
		assertEquals(oldPos.x() - 1, model.state.position.x());
	}
	
	@Test
	public void testMoveRight() throws Exception {
		var oldPos = model.state.position;
		model.moveRight();
		assertEquals(oldPos.x() + 1, model.state.position.x());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
