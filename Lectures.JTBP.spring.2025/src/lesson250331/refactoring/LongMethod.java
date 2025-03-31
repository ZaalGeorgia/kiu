package lesson250331.refactoring;

public class LongMethod {
	
	public static void main(final String[] args) {
		
		System.out.println("hello");
		
		sayWorld();
		
		makeExclamation();
		
		int x = 10;
		
		int y = 20;
		
		int z;
		
		x++;
		y++;
		
		System.out.println(x);
		System.out.println(y);
		
	}

	private static void makeExclamation() {
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
		System.out.println("!!!");
	}

	private static void sayWorld() {
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
		System.out.println("world");
	}

}
