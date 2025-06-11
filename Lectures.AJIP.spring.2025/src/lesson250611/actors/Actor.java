package lesson250611.actors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Actor {
	
	private final ExecutorService service = 
			Executors.newSingleThreadExecutor(Thread.ofVirtual().factory());
	
	public void accept(Command command) {
		service.submit(() -> {
			process(command);
		});
	}

	private void process(Command command) {
		System.out.println("received " + command);
		command.getSender().accept(new Command(Command.MESSAGE, "got it", this));
	}

}
