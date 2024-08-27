package lesson20240827.primitive;

public class Sequential {
	
	private static final int CYCLES = 1000;

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < CYCLES; i++) {
			if (i % 100 == 0) {
				System.out.println(i);
			}
			new Read(10).doWork();
			new Process(10).doWork();
			new Write(10).doWork();
		}
		
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed: " + (stop - start));
	}

}
