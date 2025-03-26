package lesson250319.threads;

public class Main {
	
	public static void main(final String[] args) throws InterruptedException {
		
		
		System.out.println(Thread.currentThread());
		
		new Thread(() -> {
			System.out.println(Thread.currentThread());
		}).start();
		
		Thread thread2 = new Thread(() -> {
			
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread());
			}
			
		}, "MyPrivateThread");
		
		thread2.setDaemon(true);
		
		thread2.start();
		
		Thread.sleep(5000);
		
	}
	
	

}
