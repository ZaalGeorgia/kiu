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
		int[][] field = model.field;
		assertNotNull(field);
		assertEquals(TetrisModel.DEFAULT_HEIGHT, field.length);
	}
	
	@Test
	public void testColorsRange() throws Exception {
		assertEquals(TetrisModel.DEFAULT_COLORS_NUMBER, model.maxColors);
	}

	@Test
	public void testFigureCreated() throws Exception {
		int[][] figure = model.figure;
		assertNotNull(figure);
	}
	
	@Test
	public void positionExists() throws Exception {
		Pair p = model.position;
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
		int old = model.position.y();
		model.slideDown();
		assertEquals(old + 1, model.position.y());
	}
	
	@Test
	public void testFigureNotOverlapsFieldCellsAfterSlidingDown() throws Exception {
		model.field[2][model.size().x()/2] = 1;
		boolean valid = model.isNewFiguresPositionValid(new Pair(model.position.x(), model.position.y() + 1));
		assertFalse(valid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
