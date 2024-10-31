package lesson20241031;

public class UseFlyable3 {
	
	public static void main(String[] args) {
	
		Baloon baloon = new Baloon();
		Bird bird = new Bird();
		Airplane airplane = new Airplane();
		
		Object o = baloon;
		
		Flyable f = bird;
		
		f = (Flyable) o;
		System.out.println(f);
		
		
		f = (Bird) o;
	}

}
