package lesson250326.exceptions;

public class ExampleTwo {
	
	public static void main(final String[] args) {
		
		new Thread(() -> {
			System.out.println("start");
			makeCalculations();
			System.out.println("finish");
		}).start();
		
		while (true) {
			utils.Utils.pause(5000);
			new Exception().printStackTrace();
		}
		
	}
	
	private static void makeCalculations() {
		System.out.println("begin calculations");
		System.out.println(average(100, 0));
		System.out.println("stop calculations");
	}

	private static int average(final int total, final int count) {
			return total/count;
	}

}
