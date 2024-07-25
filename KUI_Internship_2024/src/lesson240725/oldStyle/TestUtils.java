package lesson240725.oldStyle;

public class TestUtils {

	static void assertResult(String actual, String expected) {
		if (expected.equals(actual)) {
			System.out.println("test passed");
		} else {
			System.err.println("test failed: expected " + expected);
		}
	}

}
