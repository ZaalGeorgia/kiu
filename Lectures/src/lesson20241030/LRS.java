package lesson20241030;

import java.util.Arrays;

public class LRS {

	private static String lcp(String s, String t) {
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++)
			if (s.charAt(i) != t.charAt(i))
				return s.substring(0, i);
		return s.substring(0, N);
	}

	public static String lrs(String s) {
		int N = s.length();
		String[] suffixes = new String[N];
		for (int i = 0; i < N; i++)
			suffixes[i] = s.substring(i, N);
		Arrays.sort(suffixes);
		String lrs = "";
		for (int i = 0; i < N - 1; i++) {
			String x = lcp(suffixes[i], suffixes[i + 1]);
			if (x.length() > lrs.length())
				lrs = x;
		}
		return lrs;
	}
}
