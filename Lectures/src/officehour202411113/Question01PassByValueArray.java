package officehour202411113;

public class Question01PassByValueArray {
	
	public static void main(String[] args) {
		
		a(10);
		
		int k = 3;
		
		a(k); // === a(3);
		
		int newK = b(k); // === b(3);
		
		System.out.println(k);
		System.out.println(newK);
		
	}

	private static int b(int k) {
		// k = 3;
		k = 10;
		return k;
	}

	private static void a(int i) {
		// i = 10;  i = 3;
		System.out.println(i);
	}

}
