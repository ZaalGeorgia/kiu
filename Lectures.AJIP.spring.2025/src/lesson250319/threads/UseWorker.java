package lesson250319.threads;

public class UseWorker {
	
	public static void main(final String[] args) {
		
		WorkerThread worker = new WorkerThread();
		
		worker.execute(() -> {
			System.out.println(Thread.currentThread());
		});
		
	}

}
