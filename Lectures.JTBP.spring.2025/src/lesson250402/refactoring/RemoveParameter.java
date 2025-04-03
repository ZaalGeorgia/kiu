package lesson250402.refactoring;

public class RemoveParameter {
	
	public static void main(final String[] args) {
		
		
		doSomething(10, 30);
		
		doSomething(10, 30);
		
	}

	private static void doSomething(final int i, final int k) {
		System.out.println(i);
		System.out.println(k);
//		j = 30;
	}

}
