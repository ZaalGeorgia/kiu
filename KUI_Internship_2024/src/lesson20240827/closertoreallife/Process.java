package lesson20240827.closertoreallife;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class Process extends Workload {

	private BlockingQueue<String> tempStorage;

	public Process(int duration, BlockingQueue<String> tempStorage) {
		super(duration);
		this.tempStorage = tempStorage;
	}

	@Override
	protected String getData() {
		String data;
		try {
			data = tempStorage.take();
			byte[] bytes = data.getBytes();
			Arrays.sort(bytes);
			return new String(bytes);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
