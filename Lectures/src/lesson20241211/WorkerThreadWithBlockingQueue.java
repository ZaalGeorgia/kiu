package lesson20241211;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class WorkerThreadWithBlockingQueue implements Executor {
	BlockingQueue<Runnable> tasks = new ArrayBlockingQueue<>(5);


	Thread t = new Thread(() -> {
		while (true) {
			Runnable task;
			try {
				task = tasks.take();
			} catch (InterruptedException e) {
				break;
			}
			task.run();
		}
		System.out.println("stopped thread");
	});

	public WorkerThreadWithBlockingQueue() {
		t.start();
	}

	@Override
	public void execute(Runnable task) {
		try {
			tasks.put(task);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void shutdown() {
		t.interrupt();
	}

}
