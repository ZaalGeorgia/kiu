package lesson250429.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceQueue {
	
	public static void main(String[] args) {
		
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(100);
		ThreadPoolExecutor service = new ThreadPoolExecutor(0, 10, 1, TimeUnit.MINUTES, queue);
		
		
	}

}
