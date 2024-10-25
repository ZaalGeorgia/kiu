package officehour20241024;

public class ForVsWhile {
	
	public static void main(String[] args) {
		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i);
//		}
//		
		
		int i = 10;
		
		while (i < 10) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("---");
		
		int j = 10;
		
		do {
			System.out.println(j);
			j++;
		} while (j < 10);
		
	}

}
