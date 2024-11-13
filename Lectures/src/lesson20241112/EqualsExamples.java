package lesson20241112;

import java.util.Arrays;
import java.util.Iterator;

public class EqualsExamples {
	
	public static void main(String[] args) {
		
		String a = "ABC";
		
		String b = "ABC";
		
		System.out.println(a == b);
		
		
		String c = new String("ABC");

		b = "DEF";

		System.out.println(a == c);
		
		System.out.println(a.equals(c));
		
		int[] x = {0, 1, 2};
		
		int[] y = {0, 1, 2};
		
		System.out.println(x == y);
		
		boolean result = equalArrays(x, y);

		System.out.println(result);
		
		System.out.println(Arrays.equals(x,	y));
		
		x = y;
		
		System.out.println(x == y);
	}

	private static boolean equalArrays(int[] x, int[] y) {
		if (x == y) return true;
		if (x.length != y.length) return false;
		for (int i = 0; i < x.length; i++) {
			if (x[i] != y[i]) return false;
		}
		return true;
	}

}
