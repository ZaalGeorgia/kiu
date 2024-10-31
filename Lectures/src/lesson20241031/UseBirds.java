package lesson20241031;

public class UseBirds {
	
	public static void main(String[] args) {
		
		Bird[] birds = {
				new Bird(),
				new Chicken()
		};
		
		
		for (Bird bird : birds) {
			System.out.println(bird);
			bird.fly();
			bird.run();
			System.out.println();
		}
		
	}

}
