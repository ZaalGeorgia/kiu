package lesson20241211;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.Library;

public class Threads06 {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Future<Double> future = service.submit(() -> {
			Random r = new Random();
			double sum = 0;
			for (int i = 0; i < 10_000; i++) {
				sum += r.nextDouble();
				Library.pause(1);
			}
			return sum;
		});
		
		try {
			while (!future.isDone()) {
				System.out.println("not ready yet... waiting...");
				Library.pause(1000);
			}
			
			Double result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		service.shutdown();
		
		
	}

}
