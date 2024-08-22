package lesson20240822.virtual;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class VurtualActors {
	
	private static AtomicLong cnt = new AtomicLong();

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("init");
		
		List<Actor> actors = new ArrayList<>();
		
		for (int i = 0; i < 1_000_000; i++) {
			actors.add(new Actor());
		}
		
		Random r = new Random();
		
		System.out.println("start");
		
		while (true) {
			Actor actor = actors.get(r.nextInt(actors.size()));
			actor.process(() -> {
				System.out.println("command " + cnt.incrementAndGet());
			});
		}
	}

}
