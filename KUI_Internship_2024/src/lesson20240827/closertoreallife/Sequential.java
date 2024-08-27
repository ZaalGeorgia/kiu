package lesson20240827.closertoreallife;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Sequential {
	
	private static final int CYCLES = 1000;

	public static void main(String[] args) {
		
		BlockingQueue<String> read = new LinkedBlockingQueue<>(); 
		BlockingQueue<String> processed = new LinkedBlockingQueue<>(); 
		
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < CYCLES; i++) {
			if (i % 100 == 0) {
				System.out.println(i);
			}
			String readData = new Read(1).doWork();
			read.add(readData);
			String processedData = new Process(10, read).doWork();
			processed.add(processedData);
			new Write(10, processed).doWork();
		}
		
		long stop = System.currentTimeMillis();
		
		System.out.println("Elapsed: " + (stop - start));
	}

}
