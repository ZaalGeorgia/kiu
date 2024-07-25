package lesson240725.withJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void test() {
		var fb = new FizzBuzz();
		testFB(fb, 2, "2");
		testFB(fb, 4, "4");
		testFB(fb, 3, "Fizz");
		testFB(fb, 6, "Fizz");
		testFB(fb, 5, "Buzz");
		testFB(fb, 10, "Buzz");
		testFB(fb, 15, "FizzBuzz");
	}

	private void testFB(FizzBuzz fb, int input, String expected) {
		String result = fb.check(input);
		assertEquals(expected, result);
	}

}
