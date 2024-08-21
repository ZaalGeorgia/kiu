package lesson20240821;

public class RaceConditionFixedWithSync {

	static int counter = 0;
	static Object mutex = new Object();

	public static void main(String[] args) {

		new Thread(RaceConditionFixedWithSync::count).start();
		new Thread(RaceConditionFixedWithSync::count).start();
		new Thread(RaceConditionFixedWithSync::count).start();
		new Thread(RaceConditionFixedWithSync::count).start();
		new Thread(RaceConditionFixedWithSync::count).start();

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
			// mutual exclusion
			// critical section
			// atomic operation
			synchronized (mutex) {
				counter++;
			}
			pause(1000);
		}
	}

}
