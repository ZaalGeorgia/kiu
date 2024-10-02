package lesson20241002;

public class PrefixIncrease {
	
	public static void main(String[] args) {
		
		int i;
		
		i = 0;
		System.out.println(i++);
		
		i = 0;
		System.out.println(++i);
		
		System.out.println();
		
		for (int j = 0; j < 10;) {
			System.out.print(j++);
		}
		
		System.out.println();
		
		for (int j = 0; j < 10; ) {
			System.out.print(++j);
		}
		
	}

}
