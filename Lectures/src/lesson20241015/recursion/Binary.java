package lesson20241015.recursion;

import std.StdOut;

public class Binary {
	
	// even N%2 == 0
	// odd  N%2 == 1
	
	public static String convert(int N) {
		if (N == 1)
			return "1";
		return convert(N / 2) + (N % 2);
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		StdOut.println(convert(N));
	}
}