package lesson250429.threads.other_version;

import java.util.List;
import java.util.concurrent.Callable;

public class Consumer implements Callable<List<String>> {

	List<String> data;
	
	public Consumer(List<String> data) {
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
