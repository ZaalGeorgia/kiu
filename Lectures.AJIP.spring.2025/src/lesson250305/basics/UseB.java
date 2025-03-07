package lesson250305.basics;

import java.lang.reflect.Method;

public class UseB {
	
	public static void main(final String[] args) {
		B b = new B();
		
		b.global = 10;
		b.instance = 20;
		
		System.out.println(b);
		
		B b2 = new B();
		System.out.println(b2);
		
		b2.global = 30;
		
		System.out.println(b);
		
		System.out.println(B.class);
		for (Method m : b.getClass().getMethods()) {
			System.out.println(m);
		}
	}

}
