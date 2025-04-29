package lesson250429.threads.other_version;

import java.util.List;

public interface ProducerObserver {
	
	void offer(List<String> data);

}
