package lesson20240821;

public class StopThreadExample1 {

	public static void main(String[] args) throws InterruptedException {
		
		Data data = new Data();

		Thread thread = new Thread(() -> {
			int count = 0;
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				data.changeState(count);
				System.out.println(count++ + " " + data.check());
			}
		});
		thread.start();
		
		Thread.sleep(5000);
		
		thread.stop();
		
	}

}
