package lesson20241210.threads;

import utils.Library;

public class Threads02 {
	
	public static void main(String[] args) throws InterruptedException {

		Thread thread = Thread.currentThread();
		
		Library.printThreadInfo(thread);
		
		Thread myThread = new Thread();
		
		Library.printThreadInfo(myThread);
		
		myThread.start();
		Library.printThreadInfo(myThread);
		
		Thread.sleep(1000);
		Library.printThreadInfo(myThread);
		
	}

}
