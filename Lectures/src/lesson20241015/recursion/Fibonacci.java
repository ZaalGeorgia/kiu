package lesson20241015.recursion;

public class Fibonacci {
	
	static int fib (final int n) {
		if (n < 2) {  // base case
			return n;
		}
		return fib(n-2) + fib (n-1);
	}
	
	public static void main(final String[] args) {
		
		for (int i = 0; i < 50; i++) {
			System.out.println(fib(i));
		}
	}

}
