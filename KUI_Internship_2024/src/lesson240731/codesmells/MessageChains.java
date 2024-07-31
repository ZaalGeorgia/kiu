package lesson240731.codesmells;

public class MessageChains {

	public static void main(String[] args) {
		D d = new D();
		d.d().e().f();
	}
	
}


class D {
	E d() {
		return new E();
	}
}

class E {
	F e() {
		return new F();
	}
}

class F {
	void f() {
	}
}