package lesson20240827.closertoreallife;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


public class JustRead {

	public static void main(String[] args) {

		List<String> storage = new LinkedList<>();
		
		ExecutorService reader = Executors.newSingleThreadExecutor();
		
		Semaphore sem = new Semaphore(10);

		reader.execute(() -> {
			int cnt = 0;
			while (true) {
				sem.acquireUninterruptibly();
				String data = new Read(1).doWork();
				storage.add(data);
				cnt++;
				if (cnt % 1000 == 0) {
					System.out.println(cnt);
				}
			}
		});
		
		while (true) {
			try {
				Thread.sleep(10);
				System.err.println(storage.size());
				sem.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (!storage.isEmpty())
				storage.remove(0);
		}

	}

}
