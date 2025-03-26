package lesson250326.exceptions;

public class ExampleOne {
	
	public static void main(final String[] args) {
		
//		int avg = average(100, 10);
		
//		System.out.println("avg = " + avg);
		
		new Thread(() -> {
			System.out.println("start");
			makeCalculations();
			System.out.println("finish");
		}).start();
		
//		new Exception().printStackTrace();
		
//		makeCalculations();
		
	}
	
	private static void makeCalculations() {
		System.out.println("begin calculations");
		System.out.println(average(100, 0));
		System.out.println("stop calculations");
	}

	private static int average(final int total, final int count) {
		try {
			return total/count;
		} catch (ArithmeticException ae) {
			return Integer.MAX_VALUE;
		}
	}

}
