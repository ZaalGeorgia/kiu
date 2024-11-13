package officehour202411113;

import java.util.Arrays;

public class Question01PassByValue {
	
	public static void main(String[] args) {

		
		int[] a = {0, 10, 20};
		
		process(a);
		
		System.out.println(Arrays.toString(a));
		
	}

	private static void process(int[] a) {
		// a = <some address in the memory>
		System.out.println(a.length);
		a[0] = 30;
	}
		

}
