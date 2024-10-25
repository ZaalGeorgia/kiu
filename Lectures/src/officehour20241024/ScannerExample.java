package officehour20241024;

import java.util.Scanner;

public class ScannerExample {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter some lines of text please");
		
		while (scanner.hasNextLine()) { // until Ctrl-D is pressed
			String line = scanner.nextLine();
			System.out.println(line);
			if (line.equals("bye")) {
				break;
			}
		}
		
		System.out.println("end of data, goodbye");
		scanner.close();
		
	}

}
