package lesson250304.patterns.factory_method;

public class Main {
	
	public static void main(String[] args) {
		
		
		doSomething();
		
		
	}

	private static void doSomething() {
		Something s = factoryMethod();
		System.out.println(s);
	}

	private static Something factoryMethod() {
		return Math.random() < 0.5? new A() : new B();
	}

}
