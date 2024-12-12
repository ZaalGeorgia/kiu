package lesson20241211;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utils.Library;

public class Threads05 {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		ExecutorService e = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 10; i++) {
			e.execute(() -> {
				System.out.println(Thread.currentThread());
				Library.pause(1000);
			});
		}
		
		System.out.println("finish");
		
//		e.shutdownNow();
		e.shutdown();
		
	}

}
