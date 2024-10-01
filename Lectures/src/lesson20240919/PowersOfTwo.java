package lesson20240919;

public class PowersOfTwo {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int i = 0;
		int v = 1;
		while (i <= n) {  // loop body
			System.out.println(i + " -> " + v);
			v = 2 * v;
//			i = i + 1;
//			i += 1;
			i++;
		}
		System.out.println("finished");
	}
}