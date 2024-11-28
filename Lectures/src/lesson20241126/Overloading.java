package lesson20241126;

import utils.Library;

public class Overloading {
	
	public static void main(String[] args) {
		
		Library.print(args);
		
		Library.print(new int[] {0,1,2,3});
		
		A a = new B();
		a.m();
		a.v();
		
		a = new C();
		a.m();
		a.v();
		
		a = new D();
		a.m();
		a.v();
		
	}


}


class A {
	void m() {
		System.out.println("A");
	}
	
	void v() {
		System.out.println("V");
	}
}

class B extends A {
	@Override
	void m() {
		System.out.println("B");
	}
}

class C extends A {
	@Override
	void v() {
		System.out.println("CV");
	}
}

class D extends C {
	
}




