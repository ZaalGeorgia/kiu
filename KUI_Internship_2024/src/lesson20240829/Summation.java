package lesson20240829;

public class Summation {
	
	private static final int CYCLES = 10;
	private static final int NUMBERS = 100_000_000;
	private static double[] data;

	public static void main(String[] args) {
		System.out.println("initializing");
		data = new double[NUMBERS];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = Math.random();
		}
		
		System.out.println("start processing");
		long start = System.currentTimeMillis();
		
		double sum = sum(data);
		
		System.out.println(sum);
		long stop = System.currentTimeMillis();
		System.out.println("Elapsed " + (stop - start));

	}

	private static double sum(double[] data) {
		double r = 0;
		for (int i = 0; i < data.length; i++) {
			r += process(data, i);
		}
		return r;
	}

	private static double process(double[] data, int i) {
		double r = 0;
		for (int j = 0; j < CYCLES; j++) {
			r += Math.sqrt(Math.sin(data[i]));
		}
		return r;
	}

}
