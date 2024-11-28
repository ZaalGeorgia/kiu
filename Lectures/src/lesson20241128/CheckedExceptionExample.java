package lesson20241128;

public class CheckedExceptionExample {
	
	public static void main(String[] args) {
		
		System.out.println("start...");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Finish!");
		
	}

}
