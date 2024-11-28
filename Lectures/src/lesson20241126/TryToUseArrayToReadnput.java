package lesson20241126;

import java.util.Arrays;
import java.util.Scanner;

public class TryToUseArrayToReadnput {
	
	public static void main(String[] args) {
		
		String[] a = new String[3];
		
		System.out.println(Arrays.toString(a));
		
		Scanner scanner = new Scanner(System.in);
		
		int c = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			a[c] = line;
			c++;
		}
		
		
		for (String string : a) {
			System.out.println(string);
		}
	}

}
