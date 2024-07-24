package lesson240724;

import java.util.Scanner;

public class InterpreterExample {
	
	static A a = new A();
	
	public static void main(String[] args) {

		System.out.println("enter command: ");
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextLine()) {
//			process(scanner.nextLine());
			a.execute(scanner.nextLine());
		}
	}

	private static void process(String command) {
		switch (command) {
		case "one":
			a.one();
			break;
		case "two":
			a.two();
			break;
		case "three":
			a.three();
			break;
		default:
			System.out.println("unknown command");
				
		}
	}
}

