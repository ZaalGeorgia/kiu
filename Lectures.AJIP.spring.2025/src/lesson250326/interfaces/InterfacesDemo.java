package lesson250326.interfaces;

public class InterfacesDemo {
	
	public static void main(final String[] args) {
		
		C c = new C() {

			@Override
			public void a() {
				
			}

			@Override
			public void b() {
				
			}
		};
		
		c.a();
		c.b();
	}

}

interface A {
	void a();
}

interface B {
	void b();
}

interface C extends A, B {
	
}
