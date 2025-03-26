package lesson250319.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
	
	public static void main(final String[] args) {
		
		System.out.println("start");
		
		ExecutorService executor = Executors.newSingleThreadExecutor();

		for (int i = 0; i < 10; i++) {
			executor.execute(() -> {
				System.out.println(Thread.currentThread());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
		}
		
		
		executor.shutdown();
		
		System.out.println("finish");
	}

}
