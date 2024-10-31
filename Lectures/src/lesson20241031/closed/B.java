package lesson20241031.closed;

public class B {
	
	A a = new A();
	
	void doSomethingWithA() {
		a.change();
		a.helper();
//		a.anotherHelper(); COMPILE ERROR!
	}

}
