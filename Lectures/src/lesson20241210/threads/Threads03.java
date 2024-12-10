package lesson20241210.threads;

import utils.Library;

public class Threads03 {
	
	public static void main(String[] args) {
		System.out.println("start");
		
		Task task = new Task();
		
		new Thread(task).start();
		
		System.out.println("finish");
	}

}


class Task implements Runnable {

	@Override
	public void run() {
		Library.printThreadInfo(Thread.currentThread());
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
			Library.pause(1000);
		}
		Library.printThreadInfo(Thread.currentThread());
	}
	
}