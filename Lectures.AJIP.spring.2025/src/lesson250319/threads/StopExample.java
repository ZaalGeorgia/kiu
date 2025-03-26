package lesson250319.threads;

import utils.Utils;

public class StopExample {
	
	public static void main(final String[] args) {
		
		Thread thread = new Thread(() -> {
			while (true) {
				System.out.println(Thread.currentThread());
				Utils.pause(1000);
			}
		});
		
		thread.start();
		
		Utils.pause(5000);
		
		thread.stop();
		
	}

}
