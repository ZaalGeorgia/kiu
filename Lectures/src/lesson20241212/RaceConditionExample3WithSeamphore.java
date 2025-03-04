package lesson20241212;

import java.util.concurrent.Semaphore;

import utils.Library;

public class RaceConditionExample3WithSeamphore {

	public static void main(String[] args) throws InterruptedException {
		Counter2 counter = new Counter2();

		Thread t1 = new Thread(() -> {
			counter.change();
		});

		Thread t2 = new Thread(() -> {
			counter.change();
		});

		Thread t3 = new Thread(() -> {
			counter.change();
		});

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		System.out.println(utils.Test.assertEquals(counter.x, 3));
		System.out.println(counter.x);
	}

}

class Counter2 {
	int x;
	Semaphore sem = new Semaphore(1);

	void change() {
		sem.acquireUninterruptibly();
		try {
			System.out.println(Thread.currentThread() + " entered critical section");
			int t = x;
			Library.pause(5000);
			x = t + 1;
			System.out.println(Thread.currentThread() + " leaves critical section");
		} finally {
			sem.release();
		}
	}
}