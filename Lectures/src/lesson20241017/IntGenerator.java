package lesson20241017;

import java.util.Random;

public class IntGenerator {
	
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int B = Integer.parseInt(args[1]);
		
		Random r = new Random();
		
		for (int i = 0; i < N; i++) {
			int nextInt = r.nextInt(B);
			System.out.println(nextInt);
		}
	}

}
