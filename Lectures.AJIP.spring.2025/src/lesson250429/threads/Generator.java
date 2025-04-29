package lesson250429.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Generator implements Callable<List<String>> {
	
	private static final int LENGTH = 1000;

	static char[] APLHABET = {'A', 'C', 'T', 'G'};
	
	Random random = new Random();

	int size;

	public Generator(int size) {
		this.size = size;
	}


	public List<String> call() throws Exception {
		
		List<String> genes = new ArrayList<String>();
		
		for (int i = 0; i < size; i++) {
			StringBuilder sb = new StringBuilder();
			
			for (int j = 0; j < LENGTH; j++) {
				sb.append(APLHABET[random.nextInt(APLHABET.length)]);
			}
			
			String gene = sb.toString();
			genes.add(gene);
		}
		
		return genes;
	}

}
