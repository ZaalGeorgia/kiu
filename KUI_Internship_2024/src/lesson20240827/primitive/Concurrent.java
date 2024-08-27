package lesson20240827.primitive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Concurrent {
	
	private static final int CYCLES = 1000;

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService reader = Executors.newSingleThreadExecutor();
		ExecutorService processor = Executors.newSingleThreadExecutor();
		ExecutorService writer = Executors.newSingleThreadExecutor();
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < CYCLES; i++) {
			if (i % 100 == 0) {
				System.out.println(i);
			}
			reader.submit(()-> new Read(10).doWork());
			processor.submit(()-> new Process(10).doWork());
			writer.submit(()-> new Write(10).doWork());
		}
		
		reader.shutdown();
		processor.shutdown();
		writer.shutdown();
		
		boolean successful = writer.awaitTermination(1, TimeUnit.MINUTES);
		long stop = System.currentTimeMillis();
		
		System.out.println(successful ? "normal termination" : "timeout");
		
		
		System.out.println("Elapsed: " + (stop - start));
	}

}
