package lesson240725.withJUnit;

public class FizzBuzz {

	public String check(int i) {
		var result = "";
		if (i % 3 == 0)
			result += "Fizz";
		if (i % 5 == 0)
			result += "Buzz";
		return result.isEmpty()? Integer.toString(i) : result;
	}

}
