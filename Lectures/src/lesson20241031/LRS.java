package lesson20241031;

import java.util.Arrays;

public class LRS {
	
	// Longest Repeated Substring

	private static String lcp(Suffix s, Suffix t) {
		// Longest Common Prefix
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++)
			if (s.charAt(i) != t.charAt(i))
				return s.substring(0, i);
		return s.substring(0, N);
	}

	public static String lrs(String s) {

		int N = s.length();
		
		Suffix[] suffixes = new Suffix[N];
		
		for (int i = 0; i < N; i++)
			suffixes[i] = new Suffix(i, s);
		
		for (Suffix suffix : suffixes) {
			System.out.println(suffix);
		}
		
		Arrays.sort(suffixes);
		
		for (Suffix suffix : suffixes) {
			System.out.println(suffix);
		}
		
		String lrs = "";
		for (int i = 0; i < N - 1; i++) {
			String x = lcp(suffixes[i], suffixes[i + 1]);
			if (x.length() > lrs.length())
				lrs = x;
		}
		return lrs;
	}
}
