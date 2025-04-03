package lesson250402.refactoring;

public class FeatureEnvy {
	
	public static void main(String[] args) {
		A a = new A();
		a.x();
		a.y();
		a.z();
	}

}

class A {
	
	void x() {}
	void y() {}
	void z() {}
	
	void w() {
		x();
		y();
		z();
	}
	
}


class B {
	
	A a = new A();
	
	void doSomething() {
		a.w();
	}
	
}