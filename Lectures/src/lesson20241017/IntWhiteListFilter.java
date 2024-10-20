package lesson20241017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class IntWhiteListFilter {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// first part: load whitelist
		
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		
		ArrayList<String> whiteList = new ArrayList<>();
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			whiteList.add(line);
		}

		String[] strings = whiteList.toArray(new String[0]);

		int[] numbers = new int[strings.length];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(strings[i]);
		}
		
		System.out.println(Arrays.toString(numbers));
		
		scanner.close();
		
		// second part
		
		Scanner input = new Scanner(System.in);
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			int number = Integer.parseInt(line);
			if (search(numbers, number) != -1) {
				System.out.println(number);
			}
		}
	}

	private static int search(int[] whiteList, int number) {
		for (int i = 0; i < whiteList.length; i++) {
			if (whiteList[i] == number) {
				return i;
			}
		}
		return -1;
	}

}
