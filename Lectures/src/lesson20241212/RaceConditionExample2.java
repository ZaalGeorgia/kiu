package lesson20241212;

import utils.Library;

public class RaceConditionExample2 {
	
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		
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


class Counter {
	int x;
	
	void change() {
		synchronized (this) {  // critical section || atomic operation
			System.out.println(Thread.currentThread() + " entered critical section");
			int t = x;
			Library.pause(5000);
			x = t + 1;
			System.out.println(Thread.currentThread() + " leaves critical section");
		}
	}
}