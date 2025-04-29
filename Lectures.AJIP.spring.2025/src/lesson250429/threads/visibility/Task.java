package lesson250429.threads.visibility;

public class Task implements Runnable {
	
	boolean stop = false;

	@Override
	public void run() {
		long counter = 0;
		while (true) {
			synchronized (this) {
				if (stop) {
					break;
				}
			}
			counter++;
		}
		System.out.println(counter);
		
	}
	
	public void stop() {
		synchronized (this) {
			stop = true;
		}
	}

}
