package lesson20241003.functions;

import java.util.Arrays;

import utils.Library;

public class ExchangeExample {
	
	public static void main(String[] args) {
		
		int[] a = {0, 1, 2, 3};
		
		Library.exchange(a, 0, 3);
		
		System.out.println(Arrays.toString(a));
		
	}

}
