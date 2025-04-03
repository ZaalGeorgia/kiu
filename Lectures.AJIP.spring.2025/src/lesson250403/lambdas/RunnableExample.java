package lesson250403.lambdas;

public class RunnableExample {
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			System.out.println(Thread.currentThread());
		}).start();
		
	}

}
