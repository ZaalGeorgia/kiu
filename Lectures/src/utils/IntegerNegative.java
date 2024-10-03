package utils;

public class IntegerNegative {
	
	public static void main(final String[] args) {
		
		int i = Integer.MAX_VALUE;
		System.out.println(i);
		
		i++;
		System.out.println(i);

		int j = 0;
		
		while (true) {
			j++;
			
			if (j % 100_000_000 == 0) {
				System.out.println(j);
			}
		}
		
	}

}
