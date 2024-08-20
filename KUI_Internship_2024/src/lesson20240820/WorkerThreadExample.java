package lesson20240820;

import java.util.concurrent.Executor;

public class WorkerThreadExample {
	
	public static void main(String[] args) {
		
		Executor executor = new WorkerThread();
		executor.execute(() -> {
			System.out.println(Thread.currentThread());
		});
		
	}

}
