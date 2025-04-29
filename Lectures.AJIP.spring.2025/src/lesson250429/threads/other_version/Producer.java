package lesson250429.threads.other_version;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

	private static final int LENGTH = 1000;
	private static final int CHUNK_SIZE = 10_000;

	static char[] APLHABET = { 'A', 'C', 'T', 'G' };

	Random random = new Random();

	int size;

	private Thread thread;
	private ProducerObserver observer;

	public Producer(ProducerObserver observer) {
		this.observer = observer;
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
			
			observer.offer(genes);

		}

	}
	
	public void stop() {
		thread.interrupt();
	}

}
