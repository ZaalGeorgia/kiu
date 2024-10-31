package lesson20241031;

public class Bird implements Flyable {

	public void fly() {
		System.out.println("bird is flapping wings");
	}
	
	public boolean hasWings() {
		return true;
	}
	
	public void run() {
		System.out.println("somehow runs");
	}

}
