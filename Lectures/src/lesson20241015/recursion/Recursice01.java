package lesson20241015.recursion;

public class Recursice01 {
	
	public static void main(String[] args) {
		
		a(10);
		
	}

	private static void a(int i) {
		if (i < 0) return;  // base case
		a(i - 1);
		System.out.println(i);
	}

}
