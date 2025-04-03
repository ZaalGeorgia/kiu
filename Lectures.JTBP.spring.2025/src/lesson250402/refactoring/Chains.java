package lesson250402.refactoring;

public class Chains {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		String string = 
				sb.append('h')
				.append('e')
				.append('l')
				.append("lo!")
				.toString();
		
		System.out.println(string);
		
		new A1().a().b().c();
		new A1().doAll();
		
	}

}


class A1 {
	B1 a() {
		return new B1();
	}
	
	void doAll() {
		new B1().b().c();
	}
}

class B1 {
	C1 b() { return new C1();}
}

class C1 {
	void c() {}
}