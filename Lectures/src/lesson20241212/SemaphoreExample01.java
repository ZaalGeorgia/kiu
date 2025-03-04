package lesson20241212;

import java.util.concurrent.Semaphore;

import utils.Library;

public class SemaphoreExample01 {

	public static void main(String[] args) {
		
		Semaphore sem = new Semaphore(0);
		
		
		new Thread(() -> {
			System.out.println("waiting for a signal...");
			sem.acquireUninterruptibly();
			System.out.println("got a signal");
		}).start();
		
		Library.pause(5000);
		
		sem.release();
		
	}
	
}
