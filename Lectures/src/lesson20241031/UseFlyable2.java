package lesson20241031;

public class UseFlyable2 {
	
	public static void main(String[] args) {
		
		Flyable[] flyingObjects = {
				new Bird(),
				new Baloon(),
				new Airplane()
		};
		
		for (Flyable flyable : flyingObjects) {
			action(flyable);
		}
		
	}

	private static void action(Flyable flyable) {
		System.out.println(flyable);
		flyable.fly();
	}

}
