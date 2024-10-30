package lesson20241029.oop;

import java.util.Arrays;

public class StringExample {
	
	public static void main(String[] args) {
		
		System.out.println(args[0].charAt(0));
		System.out.println(args[0].charAt(1));
		System.out.println(args[0].charAt(2));
		
		
//		var s = "Hello";
		                     //01234 
		String s = new String("Hello");  // immutable
		
		System.out.println(s.length());
		
		
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
		var sub = s.substring(2);
		
		System.out.println(sub);
		
		byte[] bytes = s.getBytes();
		System.out.println(Arrays.toString(bytes));
		
		for (int i = 0; i < bytes.length; i++) {
			bytes[i]++;
		}
		
		System.out.println(new String(bytes));
		
	}

}
