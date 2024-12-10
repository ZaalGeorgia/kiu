package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class LibrarySumFunctionTest {

	@Test
	public void testSumReturnsCorrectResult() throws Exception {
		int sum = Library.sum(new int[] {1,2,3});
		assertEquals(6, sum);
	}

}
