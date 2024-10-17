package lesson20241016;

public class FibonacciMemo {

	static long memo[];
	
	
	static long fib (final int n) {
		if (n < 2) {  // base case
			return n;
		}
		if (memo[n] == 0) {
			memo[n] = fib(n-2) + fib (n-1);
		}
		return memo[n];
	}
	
	public static void main(final String[] args) {
		
		int N = Integer.parseInt(args[0]);
		
		memo = new long[N+1];
		
		for (int i = 0; i <= N; i++) {
			System.out.println(i + " -> " + fib(i));
		}
	}

}
