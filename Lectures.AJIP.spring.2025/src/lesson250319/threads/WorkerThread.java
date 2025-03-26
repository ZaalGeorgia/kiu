package lesson250319.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkerThread implements Executor {
	
	BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
	
	Runnable main = new Runnable() {
		@Override
		public void run() {
			while (true) {
				try {
					Runnable task = queue.take();
					if (task == poison) {
						break;
					}
					task.run();
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	};
	
	Runnable poison = () -> {};
	
	Thread thread = new Thread(main);
	
	public WorkerThread() {
		thread.start();
	}

	@Override
	public void execute(final Runnable task) {
		try {
			queue.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown() {
		thread.interrupt();
//		try {
//			queue.put(poison);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

}
