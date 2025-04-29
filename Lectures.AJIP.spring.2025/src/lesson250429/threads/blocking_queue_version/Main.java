package lesson250429.threads.blocking_queue_version;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		BlockingQueue<List<String>> queue = new LinkedBlockingQueue<List<String>>(100);
		
		Generator g = new Generator(queue);

		new Thread(g).start();
		
		
		while (true) {
			List<String> genesChunk;
			try {
				genesChunk = queue.take();
				Processor processor = new Processor(genesChunk);
				List<String> processed = processor.call();
				System.out.println(processed.getFirst());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

}
