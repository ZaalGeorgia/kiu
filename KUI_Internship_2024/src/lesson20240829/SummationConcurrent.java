package lesson20240829;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SummationConcurrent {
	
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
		
		service = Executors.newFixedThreadPool(3);
		
		double sum = sum(data);
		
		System.out.println(sum);
	}

	private static double sum(double[] data) {
		double sum = 0;
		for (int i = 0; i < data.length; i+=3) {
			if (i % 1000 == 0) {
				System.out.println(i);
			}
			Future<Double> f1 = submitTask(data, i);
			Future<Double> f2 = submitTask(data, i+1);
			Future<Double> f3 = submitTask(data, i+2);
			try {
				Double r1 = f1.get();
				Double r2 = f2.get();
				Double r3 = f3.get();
				sum += r1 + r2 + r3;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}

	private static Future<Double> submitTask(double[] data, int i) {
		int t = i;
		Future<Double> future = service.submit(() -> process(data, t));
		return future;
	}

	private static double process(double[] data, int i) {
		double r = 0;
		for (int j = 0; j < CYCLES; j++) {
			r += Math.sqrt(Math.sin(data[i]));
		}
		return r;
	}

}
