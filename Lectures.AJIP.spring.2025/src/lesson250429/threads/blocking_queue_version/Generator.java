package lesson250429.threads.blocking_queue_version;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Generator implements Runnable {

	private static final int LENGTH = 1000;
	private static final int CHUNK_SIZE = 10_000;

	static char[] APLHABET = { 'A', 'C', 'T', 'G' };

	Random random = new Random();

	int size;

	private BlockingQueue<List<String>> queue;
	private Thread thread;

	public Generator(BlockingQueue<List<String>> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		
		thread = Thread.currentThread();

		while (true) {

			List<String> genes = new ArrayList<String>();

			for (int i = 0; i < CHUNK_SIZE; i++) {
				StringBuilder sb = new StringBuilder();

				for (int j = 0; j < LENGTH; j++) {
					sb.append(APLHABET[random.nextInt(APLHABET.length)]);
				}

				String gene = sb.toString();
				genes.add(gene);
			}

			try {
				System.out.println(queue.size());
				queue.put(genes);
			} catch (InterruptedException e) {
				break;
			}
		}

	}
	
	public void stop() {
		thread.interrupt();
	}

}
