package lesson20240919;

public class ThreeSort {
	public static void main(String[] args) {  // method body
		if (args.length < 3) {
			System.out.println("Wrong number of params: should be 3");
			System.out.println("usage:  ThreeSort <n1> <n2> <n3>");
			return;
		}
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);

		System.out.println(a + " " + b + " " + c);
		
		// ??
		if (a > b) {
			int t = a;  // scope
			a = b;
			b = t;
		}
		
//		System.out.println(t);  // OUT OF SCOPE!
		
		System.out.println(a + " " + b + " " + c);

		if (a > c) {
			int t = a;
			a = c;
			c = t;
		}
		
		System.out.println(a + " " + b + " " + c);

		if (b > c) {
			int t = c;
			c = b;
			b = t;
		}
		
		System.out.println(a + " " + b + " " + c);
	}
}