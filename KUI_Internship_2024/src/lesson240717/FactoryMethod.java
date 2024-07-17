package lesson240717;

public class FactoryMethod {

	public static void main(String[] args) {
		A a = new A(Doer.someDoer());
		a.doSomething();
		a.doSomething();
		a.setDoer(Doer.someDoer());
		a.doSomething();
		a.doSomething();
		a.doSomething();
	}
	
}
