package lesson20241002;

public class DNAStats {
	
	public static void main(String[] args) {
		
		byte[] NUCLEOTIDES = {'A', 'T', 'C', 'G'};
		
		
		int N = 100_000_000;
		
		byte[] data = new byte[N ];
		
		for (int i = 0; i < data.length; i++) {
			int index = (int) (Math.random() * NUCLEOTIDES.length);
			data[i] = NUCLEOTIDES[index];
		}
		
		int A = 0;
		int C = 0;
		int T = 0;
		int G = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == 'A') {
				A++;
			}
			if (data[i] == 'C') {
				C++;
			}
			if (data[i] == 'T') {
				T++;
			}
			if (data[i] == 'G') {
				G++;
			}
		}
		
		System.out.println("A = " + A);
		System.out.println("C = " + C);
		System.out.println("T = " + T);
		System.out.println("G = " + G);
		
	}

}
