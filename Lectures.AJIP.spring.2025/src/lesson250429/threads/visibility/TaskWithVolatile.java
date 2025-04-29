package lesson250429.threads.visibility;

public class TaskWithVolatile implements Runnable {
	
	volatile boolean stop = false;

	@Override
	public void run() {
		long counter = 0;
		while (true) {
				if (stop) {
					break;
				}
			counter++;
		}
		System.out.println(counter);
		
	}
	
	public void stop() {
			stop = true;
	}

}
