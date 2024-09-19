package lesson20240918;

public class LeapYear {
	public static void main(String[] args) {
		int year = Integer.parseInt(args[0]);

		boolean isLeapYear;
		
		// divisible by 4 but not 100
		
		// or divisible by 400
		boolean divisibleBy4 = year % 4 == 0;
		boolean notDivisibleBy100 = year % 100 != 0;
		boolean divisibleBy400 = year % 400 == 0;
		
		isLeapYear = divisibleBy4 && notDivisibleBy100 || divisibleBy400;
		
		System.out.println(isLeapYear);
	}
}