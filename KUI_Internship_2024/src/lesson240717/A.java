package lesson240717;

public class A {
	
	public A(Doer someDoer) {
		doer = someDoer;
	}
	
	Doer doer;
	
	public void setDoer(Doer doer) {
		this.doer = doer;
	}

	public void doSomething() {
		doer.doItForMe();
	}

}
