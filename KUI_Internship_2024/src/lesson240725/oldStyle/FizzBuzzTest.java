package lesson240725.oldStyle;

public class FizzBuzzTest {

	static void testFB(FizzBuzz fb, int input, String expected) {
		String result = fb.check(input);
		TestUtils.assertResult(result, expected);
	}

	public static void main(String[] args) {
		var fb = new FizzBuzz();
		testFB(fb, 2, "2");
		testFB(fb, 4, "4");
		testFB(fb, 3, "Fizz");
		testFB(fb, 6, "Fizz");
		testFB(fb, 5, "Buzz");
		testFB(fb, 15, "FizzBuzz");
	}

}
