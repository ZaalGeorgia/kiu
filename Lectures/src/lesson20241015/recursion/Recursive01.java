package lesson20241015.recursion;

public class Recursive01 {
	
	public static void main(String[] args) {
		
		printNumbers(2);
		
	}

	private static void printNumbers(int i) {
		if (i < 0) return;  // base case
		System.out.println(i);
		printNumbers(i-1);
	}

}
