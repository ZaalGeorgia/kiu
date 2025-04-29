package lesson250429.threads.sync_utils;

import java.util.concurrent.SynchronousQueue;

import utils.Utils;

public class SyncQueueExample2 {
	
	public static void main(String[] args) {
		
		SynchronousQueue<String> q = new SynchronousQueue<String>();
		
		Thread thread = new Thread(() -> {
			while (true) {
				String result;
				try {
					result = q.take();
					System.out.println(result);
				} catch (InterruptedException e) {
					break;
				}
			}
		});
		thread.start();
		
		Utils.pause(5000);

		thread.interrupt();
		
	}

}
