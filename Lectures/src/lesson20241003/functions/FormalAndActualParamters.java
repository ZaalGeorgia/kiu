package lesson20241003.functions;

public class FormalAndActualParamters {
	
	public static void main(final String[] args) {
		
		final int r = square(2);
		
		System.out.println(r);
		
		final int i = 0;
		
		set10(i);
		
		System.out.println(i);
	}

	private static int square(final int i) {
		//  i == 2
		return i * i;
	}
	
	static void set10(int i) {
		i = 10;
	}

}
