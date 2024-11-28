package lesson20241128;

public class FinallyExample {
	
	public static void main(String[] args) {
		
		try {
			System.out.println("try");
			process();
			System.out.println("done");
		} catch (Exception e) {
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}
		
		
		
	}

	private static void process() {
		throw new RuntimeException("haha");
	}

}
