package lesson20241211;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Library;

public class WorkerThreadWithLocks implements Executor {
	Queue<Runnable> tasks = new LinkedList<>();

	Lock lock = new ReentrantLock();
	Condition queueIsNotEmpty = lock.newCondition();

	Thread t = new Thread(() -> {
		while (true) {
			lock.lock();
			try {
				queueIsNotEmpty.await();
			} catch (InterruptedException e) {
				break;
			}
			lock.unlock();
			Runnable task = tasks.remove();
			task.run();
		}
		System.out.println("stopped thread");
	});

	public WorkerThreadWithLocks() {
		t.start();
	}

	@Override
	public void execute(Runnable task) {
		lock.lock();
		tasks.add(task);
		queueIsNotEmpty.signal();
		lock.unlock();
	}

	public void shutdown() {
		t.interrupt();
	}

}
