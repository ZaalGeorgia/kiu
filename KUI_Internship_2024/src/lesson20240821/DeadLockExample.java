package lesson20240821;

public class DeadLockExample {
	
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		new Thread(() -> {
			synchronized (obj1) {
				System.out.println("got obj1 at " + Thread.currentThread());
				synchronized (obj2) {
					System.out.println("got both! at " + Thread.currentThread());
				}
			}
			
		}).start();
		
		new Thread(() -> {
			synchronized (obj2) {
				System.out.println("got obj2 at " + Thread.currentThread());
				synchronized (obj1) {
					System.out.println("got both! at " + Thread.currentThread());
				}
			}
			
		}).start();
		
	}
	

}
