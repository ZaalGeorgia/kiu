package lesson20240821;

public class StopThreadExample5 {

	static volatile boolean stopped = false;

	public static void main(String[] args) throws InterruptedException {
		
		Data data = new Data();
		

		Thread thread = new Thread(() -> {
			int count = 0;
			while (!stopped) {
				data.changeState(count++);
			}
		});
		
		thread.start();
		
		Thread.sleep(5000);

		stopped = true;
		
		System.out.println(data.check());
		System.out.println(data.x);
		System.out.println(data.y);

	}

}

