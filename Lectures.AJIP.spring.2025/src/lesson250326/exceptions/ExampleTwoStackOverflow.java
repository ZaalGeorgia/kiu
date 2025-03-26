package lesson250326.exceptions;

public class ExampleTwoStackOverflow {
	
	public static void main(final String[] args) {
		
		a();
	}

	private static void a() {
		a();
	}

}
