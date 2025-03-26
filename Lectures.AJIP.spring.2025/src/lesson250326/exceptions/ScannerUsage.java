package lesson250326.exceptions;

import java.util.Scanner;

public class ScannerUsage {
	
	public static void main(final String[] args) {
		
		try (Scanner s = new Scanner(System.in)) {
			
			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
		}
		
		
	}

}
