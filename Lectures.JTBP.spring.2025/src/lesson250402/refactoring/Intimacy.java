package lesson250402.refactoring;

public class Intimacy {

}


class X {
	int x;
	
	public void p() {}
	void d() {}
}


class Y {
	X x = new X();
	
	void m() {
		x.x = 10;
		x.d();
	}
}