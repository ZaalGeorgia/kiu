package lesson250319.threads;

public class CreateThreadOtherWay {
	
	public static void main(final String[] args) {
		
		
		class TaskThread extends Thread {
			
			@Override
			public void run() {
				
			}
		};
		
		new TaskThread();
		
		new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
	}

}
