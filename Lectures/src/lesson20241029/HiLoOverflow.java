package lesson20241029;

public class HiLoOverflow {
	
	public static void main(String[] args) {
		
		int lo = 1_000_000_000;
		int hi = 1_500_000_000;
		
		int mid1 = (hi + lo) / 2;
		int mid2 = lo + (hi - lo) / 2;
		
		System.out.println(mid1);
		System.out.println(mid2);
		
	}

}
