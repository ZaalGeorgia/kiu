package lesson250429.threads.other_version;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Semaphore sem = new Semaphore(100);
		
		Producer g = new Producer(data -> {

			sem.acquireUninterruptibly();
			
			executor.execute(() -> {
				Consumer consumer = new Consumer(data);
				try {
					List<String> processed = consumer.call();
					System.out.println(processed.getFirst());
				} catch (Exception e) {
					e.printStackTrace();
				}
				sem.release();
			});
		});

		new Thread(g).start();
		
		
	}

}
