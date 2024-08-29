package lesson20240829;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SummationConcurrentCorrected {
	
	private static final int CYCLES = 10;
	private static final int NUMBERS = 100_000_000;
	private static double[] data;
	private static ExecutorService service;

	public static void main(String[] args) {
		System.out.println("initializing");
		data = new double[NUMBERS];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = Math.random();
		}
		
		System.out.println("start processing");
		
		long start = System.currentTimeMillis();
		
		service = Executors.newFixedThreadPool(3);
		
		Future<Double> f1 = sum(data, 0, NUMBERS/2);
		Future<Double> f2 = sum(data, NUMBERS/2 + 1, NUMBERS);
		
		try {
			System.out.println(f1.get() + f2.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		long stop = System.currentTimeMillis();
		System.out.println("Elapsed " + (stop - start));
		service.shutdown();
	}

	private static Future<Double> sum(double[] data, int begin, int end) {
		
		return service.submit(() -> {
			double sum = 0;
			for (int i = begin; i < end; i++) {
				sum += process(data, i);
			}
			return sum;
		});
		
	}

	private static double process(double[] data, int i) {
		double r = 0;
		for (int j = 0; j < CYCLES; j++) {
			r += Math.sqrt(Math.sin(data[i]));
		}
		return r;
	}

}
