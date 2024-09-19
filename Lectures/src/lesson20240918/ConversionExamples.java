package lesson20240918;

public class ConversionExamples {
	
	public static void main(String[] args) {
		
		int a = (int) 2.7878;
		
		System.out.println(a);
		
		long round = Math.round(2.71828);
		a = (int) round;
		
		System.out.println(Long.MAX_VALUE);
		
		a = (int) Long.MAX_VALUE;
		
		System.out.println(a);
	}

}
