package lesson20240820;

public class RaceCondition {

	static int counter = 0;

	public static void main(String[] args) {

		new Thread(RaceCondition::count).start();
		new Thread(RaceCondition::count).start();
		new Thread(RaceCondition::count).start();
		new Thread(RaceCondition::count).start();
		new Thread(RaceCondition::count).start();

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
			int tmp = counter;
			pause(200);
			tmp++;
			pause(200);
			counter = tmp;
			
			pause(600);
		}
	}

}
