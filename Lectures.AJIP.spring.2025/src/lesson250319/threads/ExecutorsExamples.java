package lesson250319.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import utils.Utils;

public class ExecutorsExamples {
	
	public static void main(final String[] args) {
		
		System.out.println("start");
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		Callable<Integer> task = () -> {
			Utils.pause(5000);
			return 42;
		};
		
		System.out.println("submit");
		Future<Integer> future = pool.submit(task);
		
		pool.shutdown();
		
		try {
			System.out.println("waiting for result...");
			Integer result = future.get();
			System.out.println("result: " + result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}

}
