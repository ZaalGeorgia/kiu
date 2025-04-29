package lesson250429.threads;

import java.util.List;
import java.util.concurrent.Callable;

public class Processor implements Callable<List<String>> {

	List<String> data;
	
	public Processor(List<String> data) {
		this.data = data;
	}

	@Override
	public List<String> call() throws Exception {
		return data
				.stream()
				.parallel()
				.map(String::toLowerCase)
				.sorted()
				.toList();
	}

}
