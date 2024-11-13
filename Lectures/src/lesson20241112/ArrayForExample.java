package lesson20241112;

public class ArrayForExample {
	
	public static void main(String[] args) {
		
		int[] a = {0,1,2,3,4,5};
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		for (int i = a.length - 1 ; i >= 0; i--) {
			System.out.println(a[i]);	
		}
		
		int i = a.length - 1;
		while (i>=0) {
			System.out.println(a[i]);
			i--;
		}
		
	}

}
