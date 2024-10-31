package lesson20241031;

import java.util.Scanner;

public class UseLRS {
	
	// aacaagtttacaagc
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			String lrs = LRS.lrs(line);
			
			System.out.println(lrs);
		}
		
	}

}
