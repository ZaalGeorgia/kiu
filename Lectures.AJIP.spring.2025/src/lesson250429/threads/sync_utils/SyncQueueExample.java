package lesson250429.threads.sync_utils;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class SyncQueueExample {
	
	public static void main(String[] args) {
		
		SynchronousQueue<String> q = new SynchronousQueue<String>();
		
		Thread thread = new Thread(() -> {
			while (true) {
				String result;
				try {
					result = q.take();
					System.out.println(result);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		
		try (Scanner s = new Scanner(System.in) ) {
			while (s.hasNextLine()) {
				String input = s.nextLine();
				System.out.println(input);
				q.put(input);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
