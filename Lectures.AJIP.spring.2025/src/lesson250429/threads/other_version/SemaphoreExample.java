package lesson250429.threads.other_version;

import java.util.concurrent.Semaphore;

import utils.Utils;

public class SemaphoreExample {
	
	public static void main(String[] args) {

		System.out.println("start");
		Semaphore sem = new Semaphore(-1);
		
		new Thread(() -> {
			System.out.println(Thread.currentThread());
			Utils.pause(5000);
			sem.release();
		}).start();
		
		new Thread(() -> {
			System.out.println(Thread.currentThread());
			Utils.pause(10000);
			sem.release();
		}).start();
		
		System.out.println("wait");
		
		sem.acquireUninterruptibly();
		
		System.out.println("finish");
	}

}
