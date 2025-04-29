package lesson250429.threads;

import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("start");
		
		Generator g = new Generator(3_000_000);
		
		try {
			List<String> genes = g.call();
			System.out.println(genes.size());
			Processor processor = new Processor(genes);
			List<String> processed = processor.call();
			System.out.println(processed.getFirst());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
