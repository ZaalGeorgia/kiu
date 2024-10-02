package lesson20241002;

public class InfiniteLoop {
	
	public static void main(String[] args) {
		
		int i = 0;
		
		long start = System.nanoTime();
		
		while (true) {
			if (i++ == 2_000_000_000) {
				break;
			}
		}
		
		long stop = System.nanoTime();
		
		System.out.println("Elapsed " + (stop - start));
	}

}
