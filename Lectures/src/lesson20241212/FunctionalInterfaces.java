package lesson20241212;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalInterfaces {
	
	public static void main(String[] args) {
		
		
		Runnable r1 = new Task();
		
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				System.out.println("anonymous");
			}
		};
		
		Runnable r3 = () -> {
			System.out.println("lambda");
		};
		
		process(r1);
		process(r2);
		process(r3);
		
		process(() -> { System.out.println("inline");});
		
		Function<Integer, Integer> abs = (p) -> Math.abs(p);
		
		System.out.println(abs.apply(-10));
		
		BiFunction<Integer, Integer, Integer> sum = (i, j) -> i + j;
		
		System.out.println(sum.apply(10, 20));
		
	}

	private static void process(Runnable r) {
		r.run();
	}

}

class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("task class");
	}
	
}
