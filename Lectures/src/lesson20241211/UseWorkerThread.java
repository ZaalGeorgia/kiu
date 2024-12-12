package lesson20241211;

import java.util.concurrent.Executor;

public class UseWorkerThread {
	
	public static void main(String[] args) {
		
//		Executor executor = new WorkerThread();
//		WorkerThreadWithWaitNotify executor = new WorkerThreadWithWaitNotify();
//		WorkerThreadWithLocks executor = new WorkerThreadWithLocks();
		WorkerThreadWithBlockingQueue executor = new WorkerThreadWithBlockingQueue();
		
		executor.execute(() -> {
			System.out.println(Thread.currentThread());
		});
		
		executor.shutdown();
	}

}
