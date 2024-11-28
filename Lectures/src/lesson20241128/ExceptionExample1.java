package lesson20241128;

public class ExceptionExample1 {

	public static void main(String[] args) {

		int i = convert(args[0]);
		int j = convert(args[1]);
		
//		if (j == 0) {
//			System.out.println("can't divide by 0");
//			System.exit(1);
//		}

		try {

			int r = i / i;
			System.out.println(r);

		} catch (Exception e) {
			System.out.println("Bad input: " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("continuing operations");


	}

	private static int convert(String arg) {
		try {
			return Integer.parseInt(arg);
		} catch (Exception e) {
			System.out.println("can't convert " + arg + " to a number");
			System.exit(1);
			return 0;
		}
	}

}
