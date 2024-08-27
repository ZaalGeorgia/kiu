package lesson20240827.closertoreallife;

public abstract class Workload {
	
	private int duration;

	public Workload(int duration) {
		this.duration = duration;
	}
	
	public String doWork() {
		try {
			Thread.sleep(duration);  // imitate work
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return getData();
	}

	protected abstract String getData();

}
