package lesson20240820;

public class DaemonThreadExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("start");
		
		Thread thread = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println(Thread.currentThread());
			}
		});
		thread.setDaemon(true);
		thread.start();
		System.out.println("waiting...");
		
		Thread.sleep(5000);
		
		System.out.println("finish");
	}

}
