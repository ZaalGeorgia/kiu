package lesson250326.exceptions;

public class FinallyQuestion {
	
	public static void main(final String[] args) {
		
		int r = calculate();
		
		System.out.println(r);
	}

	private static int calculate() {
		try {
			return 10;
		} finally {
			return 0;
		}
	}

}
