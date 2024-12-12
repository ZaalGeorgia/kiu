package lesson20241211;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

import utils.Library;

public class WorkerThreadWithWaitNotify implements Executor {
	Queue<Runnable> tasks = new LinkedList<>();

	Thread t = new Thread(() -> {
		while (true) {
			synchronized (tasks) {
				try {
					tasks.wait();
				} catch (InterruptedException e) {
					System.out.println("thread is interrupted");
					break;
				}
			}
			Runnable task = tasks.remove();
			task.run();
		}
		System.out.println("stopped thread");
	});

	public WorkerThreadWithWaitNotify() {
		t.start();
	}

	@Override
	public void execute(Runnable task) {
		synchronized (tasks) {
			tasks.add(task);
			tasks.notify();
		}
	}
	
	public void shutdown() {
		t.interrupt();
	}

}
