package lesson20241210.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Threads04 {
	
	private static final int PORTION_SIZE = 10_000_000;
	private static final int SIZE = 100_000_000;

	public static void main(String[] args) throws InterruptedException {
		
		double[] data = new double[SIZE];
		
		List<Thread> threads = new ArrayList<>();
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < data.length; i+= PORTION_SIZE) {
			int k = i;
			Thread t = new Thread(() -> {
				fill(data, k, k + PORTION_SIZE);
			});
			t.start();
			threads.add(t);
		}
		
		System.out.println(threads);
		
		for (Thread thread : threads) {
			thread.join();
		}
		
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed: " + (stop - start));
	}

	private static void fill(double[] data, int from, int to) {
		Random r = new Random();
		System.out.println(Thread.currentThread() + " from=" + from + " to="+to);
		for (int i = from; i < to; i++) {
			data[i] = r.nextDouble();
		}
	}

}
