package lesson20241112;

public class TernaryOperator {
	
	public static void main(String[] args) {
		String result = flip();
	}

	private static String flip() {
		if (Math.random() < 0.5)
			return "Heads";
		else
			return "Tails";
	}

	private static String flipT() {
		return Math.random() < 0.5 ? "Heads" : "Tails";
	}
	
}
