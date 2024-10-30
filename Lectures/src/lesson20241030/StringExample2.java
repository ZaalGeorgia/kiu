package lesson20241030;

import java.util.Arrays;

public class StringExample2 {
	
	public static void main(String[] args) {
		
		String s = new String("Hello");  // immutable
//		String s2 = "Hello";  // immutable
		
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
