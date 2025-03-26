package lesson250319.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import utils.Utils;

public class RaceCondition {
	static Object mutex = new Object();
	static int cnt;
	
	static Lock lock = new ReentrantLock();

	static Semaphore sem = new Semaphore(1);
	
	public static void main(final String[] args) {
		
		Runnable task = new Counter();

		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();

	}

}

class Counter implements Runnable {

	@Override
	public void run() {
		while (true) {
			Utils.pause(1000);
//			synchronized (RaceCondition.mutex) {
//			RaceCondition.lock.lock();
			RaceCondition.sem.acquireUninterruptibly();
			try {
				int t = RaceCondition.cnt;
				Utils.pause(200);
				t = t + 1;
				Utils.pause(200);
				RaceCondition.cnt = t;
			} finally {
//				RaceCondition.lock.unlock();
				RaceCondition.sem.release();
			}
//			}
			System.out.println(RaceCondition.cnt);
		}
	}

}
