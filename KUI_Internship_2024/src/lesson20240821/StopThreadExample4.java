package lesson20240821;

import java.util.concurrent.atomic.AtomicBoolean;

public class StopThreadExample4 {

	static AtomicBoolean stopped = new AtomicBoolean();

	public static void main(String[] args) throws InterruptedException {
		
		Data data = new Data();
		

		Thread thread = new Thread(() -> {
			int count = 0;
			while (!stopped.get()) {
				data.changeState(count);
			}
		});
		
		thread.start();
		
		Thread.sleep(5000);

		stopped.set(true);
		
		System.out.println(data.check());
		System.out.println(data.x);
		System.out.println(data.y);

	}

}

