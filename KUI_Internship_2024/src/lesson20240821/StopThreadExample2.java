package lesson20240821;

public class StopThreadExample2 {

	public static void main(String[] args) throws InterruptedException {
		
		Data data = new Data();

		Thread thread = new Thread(() -> {
			int count = 0;
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
				data.changeState(count);
				System.out.println(count++ + " " + data.check());
			}
		});
		thread.start();
		
		Thread.sleep(5000);

		thread.interrupt();
		
		System.out.println(data.check());
		System.out.println(data.x);
		System.out.println(data.y);

	}

}

