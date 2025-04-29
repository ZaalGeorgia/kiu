package lesson250429.threads.blocking_queue_version;

import java.util.List;
import java.util.concurrent.Callable;

public class Processor implements Callable<List<String>> {

	List<String> data;
	
	public Processor(List<String> data) {
		this.data = data;
	}

	@Override
	public List<String> call() throws Exception {
		Thread.sleep(100);
		return data
				.stream()
				.map(String::toLowerCase)
				.sorted()
				.toList();
	}

}
