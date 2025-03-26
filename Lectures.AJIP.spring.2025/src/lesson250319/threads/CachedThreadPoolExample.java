package lesson250319.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utils.Utils;

public class CachedThreadPoolExample {
	
	
	public static void main(final String[] args) {
		
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Runnable task = () -> {
			Utils.pause(5000);
			System.out.println(Thread.currentThread());
		};
		
		for (int i = 0; i < 200; i++) {
			service.execute(task);
			Utils.pause(100);
		}
	}

}
