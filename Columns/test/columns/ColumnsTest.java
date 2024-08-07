package columns;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ColumnsTest {

	@Test
	public void testRotateCells() {
		int [] data = {0, 1, 2};
		int [] rotatedLeft = {1, 2, 0};
		Figure.rotateArraysElementsLeft(data);
		assertArrayEquals(rotatedLeft, data);
	}

	@Test
	public void testRotateCellsRight() {
		int [] data = {0, 1, 2};
		int [] rotatedRight = {2, 0, 1};
		Figure.rotateArraysElementsRight(data);
		assertArrayEquals(rotatedRight, data);
	}
	
	@Test
	public void testModelListenersAreInitialized() throws Exception {
		Model model = new Model();
		assertNotNull(model.listeners);
	}
	
}
