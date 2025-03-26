package lesson250319.threads;

import utils.Utils;

public class InterruptExample {
	
	static long x = 0;
	
	public static void main(final String[] args) {
		
		Thread t = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				x++;
			}
			System.out.println(x);
		});
		
		t.start();
		
		Utils.pause(5000);
		
		t.interrupt();
		
		
	}

}
