package lesson20240919;

public class Flip {
	public static void main(String[] args) {
		boolean condition = Math.random() < 0.5;
		if (condition)
			System.out.println("Heads");
		else
			System.out.println("Tails");
	}
}