package lesson20241017;

public class FibonacciLoop {

	static long f[] = new long[100];
	
	public static void main(String[] args) {
		
		f[0] = 0;
		f[1] = 1;
		
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i-2] + f[i-1];
		}
		
		for (int i = 0; i <= 50; i++) {
			System.out.println(i + " -> " + f[i]);
		}
		
	}

}
