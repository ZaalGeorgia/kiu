package lesson20240827.closertoreallife;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Concurrent {
	
	private static final int CYCLES = 100_000;

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService reader = Executors.newSingleThreadExecutor();
		ExecutorService processor = Executors.newSingleThreadExecutor();
		ExecutorService writer = Executors.newSingleThreadExecutor();
		
		BlockingQueue<String> read = new LinkedBlockingQueue<>(10); 
		BlockingQueue<String> processed = new LinkedBlockingQueue<>(10);
		
		AtomicInteger counter = new AtomicInteger();

		long start = System.currentTimeMillis();
		
		for (int i = 0; i < CYCLES; i++) {
			if (i % 100 == 0) {
				System.out.println(i);
			}
			reader.submit(()-> {
				String data = new Read(1).doWork();
				try {
					long begin = System.nanoTime();
					read.put(data);
					long end = System.nanoTime();
					System.out.println(counter.incrementAndGet() + " waited " + (end-begin));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			processor.submit(() -> {
				String data = new Process(500, read).doWork();
				try {
					processed.put(data);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			writer.submit(()-> new Write(10, processed).doWork());
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
