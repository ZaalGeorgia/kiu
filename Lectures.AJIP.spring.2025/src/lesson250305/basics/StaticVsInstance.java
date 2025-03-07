package lesson250305.basics;

public class StaticVsInstance {
	
	public static void main(final String[] args) {
		Z z1 = new Z();
		
		Z z2 = new Z();
		
		z1.i = 30;

		z1.printAll();
		
		Z.s = 50;
		z2.i = 100;

		z1.printAll();
	}

}

class Z {
	
	static int s = 10;
	
	int i = 20;
	
	void printAll() {
		System.out.println(s + " " + i);
	}
	
	static void print() {
//		this.s;  COMPILE ERROR!
//		System.out.println(s + " " + i);  COMPILE ERROR!
	}
	
}
