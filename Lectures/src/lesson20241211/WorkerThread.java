package lesson20241211;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

import utils.Library;

public class WorkerThread implements Executor {
	Queue<Runnable> tasks = new LinkedList<>();

	Thread t = new Thread(() -> {
		while (true) {
			while (tasks.isEmpty()) {
				Library.pause(10);
			}
			Runnable task = tasks.remove();
			task.run();
		}
	});

	public WorkerThread() {
		t.start();
	}

	@Override
	public void execute(Runnable task) {
		tasks.add(task);
	}

}
