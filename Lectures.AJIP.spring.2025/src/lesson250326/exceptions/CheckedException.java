package lesson250326.exceptions;

public class CheckedException {
	
	public static void main(final String[] args) {
		
		System.out.println("main start");
		superProcess();
		System.out.println("main stop");
	}

	private static void superProcess() {
		try {
			mainProcess();
		} catch (Exception e) {
			// swallowing the exception
		}
	}

	private static void mainProcess() throws Exception {
		localProcess();
	}

	private static void localProcess() throws Exception {

		System.out.println("start...");
//		throw new RuntimeException();
		throw new Exception();
//		System.out.println("finish");  Unreachable code, compile error
		
		
	}

}
