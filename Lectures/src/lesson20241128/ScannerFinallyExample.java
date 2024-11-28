package lesson20241128;

import java.util.Scanner;

public class ScannerFinallyExample {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} finally {
			scanner.close();
		}
		
		
		
	}

}
