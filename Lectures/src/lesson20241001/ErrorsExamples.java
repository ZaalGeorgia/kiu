package lesson20241001;

public class ErrorsExamples {
	
	public static void main(String[] args) {

		//  wrong version
//		double[] a = new double[10];
//		for (int i = 1; i <= 10; i++) {
//			System.out.print(i + " -> ");
//			a[i] = Math.random();
//			System.out.println(a[i]);
//		}
//		
		// Correct version:
		
//		double[] a = new double[10];
//		for (int i = 0; i < 10; i++) {
//			System.out.print(i + " -> ");
//			a[i] = Math.random();
//			System.out.println(a[i]);
//		}

		double[] a = new double[9];
		for (int i = 0; i < 9; i++) {
			a[i] = Math.random();
			System.out.println(a[i]);
		}
		
	}

}
