package lesson20240821;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionFixedWithAtomics {

	static AtomicInteger counter = new AtomicInteger();

	public static void main(String[] args) {

		new Thread(RaceConditionFixedWithAtomics::count).start();
		new Thread(RaceConditionFixedWithAtomics::count).start();
		new Thread(RaceConditionFixedWithAtomics::count).start();
		new Thread(RaceConditionFixedWithAtomics::count).start();
		new Thread(RaceConditionFixedWithAtomics::count).start();

		int seconds = 0;
		while (true) {
			pause(1000);
			seconds++;
			System.out.println(" passed " + seconds + " secs,  counter = " + counter);
		}

	}

	private static void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void count() {
		while (true) {
			// atomic operation
			counter.incrementAndGet();
			pause(1000);
		}
	}

}
