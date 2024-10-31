package lesson20241031;

import lesson20241031.closed.*;

public class UseA {
	
	public static void main(String[] args) {
		
		A a = new A();
		
		a.change();
		
//		a.state = 10;  COMPILE ERROR!
		
		B b = new B();
		
		var c = new C();
		
	}

}
