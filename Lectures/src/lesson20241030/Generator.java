package lesson20241030;

import std.StdOut;
import std.StdRandom;

public class Generator {
	public static String randomString(int L, String alpha) {
		char[] a = new char[L];
		for (int i = 0; i < L; i++) {
			int t = StdRandom.uniform(alpha.length());
			a[i] = alpha.charAt(t);
		}
		return new String(a);
	}

	public static void main(String[] args)

	{
		int N = Integer.parseInt(args[0]);
		int L = Integer.parseInt(args[1]);
		String alpha = args[2];
		for (int i = 0; i < N; i++)
			StdOut.println(randomString(L, alpha));

	}
}