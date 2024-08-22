package lesson20240822.virtual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Actor {

	static final ThreadFactory factory = Thread.ofVirtual().name("actor=", 0).factory();

	ExecutorService executor = Executors.newSingleThreadExecutor(factory);

	public void process(Runnable task) {
		executor.submit(() -> {
			task.run();
		});
	}

}
