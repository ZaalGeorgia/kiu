package lesson20241031;

public class Chicken extends Bird {
	
	@Override
	public void fly() {
		System.out.println("chiken can't fly, sorry");
	}
	
	@Override
	public String toString() {
		return super.toString() + ", but actually I am an Eagle!";
	}

}
