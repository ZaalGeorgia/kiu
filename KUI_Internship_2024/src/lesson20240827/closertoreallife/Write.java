package lesson20240827.closertoreallife;

import java.util.concurrent.BlockingQueue;

public class Write extends Workload {

	private BlockingQueue<String> tempStorage;

	public Write(int duration, BlockingQueue<String> tempStorage) {
		super(duration);
		this.tempStorage = tempStorage;
	}

	@Override
	protected String getData() {
		String data;
		try {
			data = tempStorage.take();
			return data;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
