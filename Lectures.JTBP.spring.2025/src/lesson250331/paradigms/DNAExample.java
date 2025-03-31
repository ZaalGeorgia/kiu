package lesson250331.paradigms;

import java.util.HashMap;
import java.util.Map;

public class DNAExample {
	
	public static void main(final String[] args) {
		
		
		String DNA = "AGAAAGGCTCTGGTGGAGAACCTGTGCATGAAGGCTGTCAACCAGTCCAT";
		
		Map<String,Integer> result = findAll(DNA, 2);
		
		System.out.println(result);
	}

	private static Map<String, Integer> findAll(final String DNA, final int size) {
		
		var result = new HashMap<String, Integer>();
		
		for (int j = 0; j < DNA.length() - size ; j++) {
			String word = DNA.substring(j, j + size);
			int count = 0;
			int indexOf = j;
			while (indexOf >= 0) {
				count++;
				indexOf = DNA.indexOf(word, indexOf + 1 );
			}
			result.put(word, count);
		}
		
		return result;
	}

}

/*
 *  A C T G  
 *  
 *  A - T
 *  C - G
 * 
 * AGAAAGGCTCTGGTGGAGAACCTGTGCATGAAGGCTGTCAACCAGTCCAT
 * 
 * 
 * AGAAAGG
 * 
 * 1 AG
 * 2 GA
 * 3 AA
 * 4 AA
 * 5 AG
 * 6 GG
 * 
 * 3 AA
 * 4 AA
 * 1 AG
 * 5 AG
 * 2 GA
 * 6 GG
 * 
 */


