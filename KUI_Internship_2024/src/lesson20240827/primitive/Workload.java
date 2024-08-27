package lesson20240827.primitive;

public abstract class Workload {
	
	private int duration;

	public Workload(int duration) {
		this.duration = duration;
	}
	
	public void doWork() {
		try {
			Thread.sleep(duration);  // imitate work
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
