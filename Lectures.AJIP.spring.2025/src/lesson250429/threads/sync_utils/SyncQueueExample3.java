package lesson250429.threads.sync_utils;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SyncQueueExample3 {
	
	public static void main(String[] args) {
		
		SynchronousQueue<String> q = new SynchronousQueue<String>();
		
		try {
			boolean success = q.offer("hello", 4, TimeUnit.SECONDS);
			if (!success) {
				System.out.println("failed to offer");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
