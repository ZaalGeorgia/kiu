package utils;

public class Library {

	public static void exchange(final int[] a, final int i, final int j) {
		final int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void print(final int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void print(final String[] a) {
		for (String string: a) {
			System.out.println(string);
		}
	}
	
	public static int sum(final int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public static double sqrt(final double c, final double eps) {

		if (c < 0) {
			return Double.NaN;
		}
		double t = c;
		while (Math.abs(t - c / t) > eps * t) {
			t = (c / t + t) / 2.0;
		}
		return t;
	}

	public static void printThreadInfo(Thread thread) {
		System.out.println(thread + " " + thread.getState());
	}

	static public void pause(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
