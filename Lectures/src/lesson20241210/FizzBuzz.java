package lesson20241210;

public class FizzBuzz {

	public static String play(int n) {
		String result = "";
		if (n % 3 == 0) result += "Fizz";
		if (n % 5 == 0) result += "Buzz";
		return result.isEmpty() ? Integer.toString(n) : result;
	}

}
