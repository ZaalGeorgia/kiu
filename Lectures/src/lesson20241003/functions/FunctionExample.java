package lesson20241003.functions;

import utils.Library;

public class FunctionExample {
	
	public static void main(String[] args) {
		
		int[] a = {0, 1, 2, 3};
		
		Library.print(a);
		
		a[0] += 10;
		Library.print(a);
		
		a[1] -= 30;
		Library.print(a);
		
		int[] b = {10, 20, 30, 40};
		
		int result = Library.sum(b);
		
		System.out.println(result);
		
		System.out.println(Library.sum(a));
		
		int total = Library.sum(a) + Library.sum(b);
		
		System.out.println(total);
		
		System.out.println(Library.sqrt(2, 1E-10));
	}

}
