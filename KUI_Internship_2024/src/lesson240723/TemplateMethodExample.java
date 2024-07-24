package lesson240723;

public class TemplateMethodExample {
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.doMath());
		System.out.println(new C().doMath());
	}

}


class A {
	int i = 1;

	int doMath() { // template method
		i = i + 10;
		someOp();
		i = i / 3;
		
		return i;
	}

	protected void someOp() {
		i = i * 2;
	}
}

class C extends A {
	
	@Override
	protected void someOp() {
		i = i + 2;
	}
	
}

//class B {
//	int i = 1;
//	
//	int doMath() {
//		i = i + 10;
//		i = i + 2;
//		i = i / 3;
//		
//		return i;
//	}
//}