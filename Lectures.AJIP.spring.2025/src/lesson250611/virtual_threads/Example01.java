package lesson250611.virtual_threads;

import utils.Utils;

public class Example01 {
	
	public static void main(String[] args) {

		// for heavy CPU tasks
		new Thread(Example01::workload).start();
		
		
		// for concurrent cases, like blocking io
		Thread.startVirtualThread(Example01::workload);
	}
	
	static void workload() {
		while (true) {
			Utils.pause(1000);
			System.out.println(Thread.currentThread());
		}
	}

}
