package lesson250326.composition;

public class CompositionDemo {
	public static void main(final String[] args) {
		new B().doSomething();
		new C().doCompletelyDifferentThing();
		new D(new A()).doCompletelyDifferentThing();
		new D(new A() {
			@Override
			void doIt() {
				System.out.println("A' way to do it");
			}
		}).doCompletelyDifferentThing();
		
		E e = new E();
		e.setA(new A());
		e.doCompletelyDifferentThing();
		
		e.setA(new A() {
			@Override
			void doIt() {
				super.doIt();
				System.out.println("and addition");
			}
		});
		e.doCompletelyDifferentThing();
	}

}


class A {
	void doIt() {
		System.out.println("do it from A");
	}
}


class B extends A {
	void doSomething() {
		System.out.println("do one thing from B");
		doIt();
		System.out.println("do another thing from B");
	}
}

class C {
	A a = new A();
	
	void doCompletelyDifferentThing() {
		a.doIt();
		System.out.println("thing from C");
	}
}

class D {
	A a;
	
	public D(final A a) {
		this.a = a;
	}
	
	void doCompletelyDifferentThing() {
		a.doIt();
		System.out.println("thing from D");
	}
	
}

class E {
	A a;
	
	void setA(final A a) {
		this.a = a;
	}
	
	void doCompletelyDifferentThing() {
		a.doIt();
		System.out.println("thing from D");
	}
	
}



