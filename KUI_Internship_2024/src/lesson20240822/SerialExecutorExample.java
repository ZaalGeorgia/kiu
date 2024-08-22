package lesson20240822;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerialExecutorExample {
	
	private static int count;

	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		
		SerialExecutor serial = new SerialExecutor(threadPool);
		
		for (int i = 0; i < 1_000; i++) {
			serial.execute(() -> {
				System.out.println(Thread.currentThread() + " "+ count++);
			});
		}
		
		
	}

}
