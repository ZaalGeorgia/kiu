package lesson20240827.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		Semaphore sem = new Semaphore(-2);
		
		new Thread(()-> {
			System.out.println("waiting for a signal...");
			sem.acquireUninterruptibly();
			System.out.println("got a message!");
			System.out.println(sem.availablePermits());
		}).start();
		
		Thread.sleep(5000);
		System.out.println("ready...");
		System.out.println(sem.availablePermits());
		sem.release();
		Thread.sleep(1000);
		System.out.println("steady...");
		System.out.println(sem.availablePermits());
		sem.release();
		Thread.sleep(1000);
		System.out.println("go!");
		System.out.println(sem.availablePermits());
		sem.release();
		
	}

}
