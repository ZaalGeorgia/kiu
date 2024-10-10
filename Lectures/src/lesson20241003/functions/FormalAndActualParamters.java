package lesson20241003.functions;

public class FormalAndActualParamters {
	
	public static void main(final String[] args) {
		
		final int r = square(2);
		
		System.out.println(r);
		
		final int i;
		
		i = 20;
		
		// i = 30;  ERROR - final variable, can't change the value
		
		set10(i);
		
		System.out.println(i);
	}

	private static int square(final int i) { //  int i == 2
		return i * i;
	}
	
	static void set10(final int i) { // int i = 0
		// i = 10;  error: - can't change value of final variable 
	}

}
