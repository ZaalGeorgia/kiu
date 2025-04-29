package lesson250429.threads.visibility;

import utils.Utils;

public class VisibilityProblemExample {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		TaskWithVolatile task = new TaskWithVolatile();
		
		new Thread(task).start();
		
		Utils.pause(5000);
		
		task.stop();
		
	}

}
