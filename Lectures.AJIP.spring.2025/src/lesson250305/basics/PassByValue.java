package lesson250305.basics;

public class PassByValue {
	
	public static void main(final String[] args) {
		
		X x = new X();
		
		process(x);
		
		System.out.println(x.state);
		
		int i = 10;
		
		process(i);
		
		System.out.println(i);
		
	}

	private static void process(final int i) { // process.i = main.i
		// i == 10
//		i = 20;
	}

	private static void process(X x) {  // process.x = main.x 
		x.state = 10;
		x = new X();
		x.state = 40;
	}

}

class X {
	int state;
}