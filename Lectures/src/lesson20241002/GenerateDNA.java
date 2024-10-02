package lesson20241002;

import java.util.Arrays;

public class GenerateDNA {
	
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		
		byte[] NUCLEOTIDES = {'A', 'T', 'C', 'G'};
		
		
		byte[] data = new byte[N];
		
		for (int i = 0; i < data.length; i++) {
			int index = (int) (Math.random() * NUCLEOTIDES.length);
			data[i] = NUCLEOTIDES[index];
		}
		
		System.out.println(Arrays.toString(data));
		
		String DNA = new String(data);
		
		System.out.println(DNA);
		
	}

}
