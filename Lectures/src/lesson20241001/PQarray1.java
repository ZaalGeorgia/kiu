package lesson20241001;

public class PQarray1 {
	public static void main(String[] args) {
		int[] a = new int[6];
		int[] b = new int[a.length];
		
		b = a;
		
		for (int i = 1; i < b.length; i++) {
			b[i] = i;
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " -> " + a[i] + " ");
		}
		
		System.out.println();
		
		a[0] = 10;

		for (int i = 0; i < b.length; i++) {
			System.out.println(i + " -> " + b[i] + " ");
		}
		System.out.println();
	}
}