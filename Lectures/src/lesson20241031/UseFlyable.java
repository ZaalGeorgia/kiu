package lesson20241031;

public class UseFlyable {
	
	public static void main(String[] args) {
		
		Baloon b = new Baloon();
		
		b.fly();
		b.inflate();
		
		Flyable f = new Baloon();
		f.fly();
//		f.inflate();  COMPILE ERROR!
		
		Object o = new Baloon();
		
	}

}
