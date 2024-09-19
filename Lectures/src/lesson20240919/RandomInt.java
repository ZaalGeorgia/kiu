package lesson20240919;

public class RandomInt {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double r = Math.random();
		System.out.println(r);
		double d = r * N;
		System.out.println(d);
		int t = (int) d;
		System.out.println(t);
	}

}