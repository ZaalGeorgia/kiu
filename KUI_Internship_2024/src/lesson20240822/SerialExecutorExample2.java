package lesson20240822;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SerialExecutorExample2 {
	
	private static AtomicInteger count = new AtomicInteger();

	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
		
		Thread.sleep(10000);
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 1000; i++) {
			runActor(threadPool);
		}
		
		System.out.println("stop");
		
		
	}

	private static void runActor(ExecutorService threadPool) {
		SerialExecutor serial = new SerialExecutor(threadPool);
		
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			serial.execute(() -> {
				System.out.println(Thread.currentThread() + " "+ count.incrementAndGet());
			});
		}
	}

}
