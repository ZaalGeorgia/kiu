package lesson20241017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class IntWhiteListFilterWithBinarySearch {
	
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
		
		Arrays.sort(numbers);
		
//		System.out.println(Arrays.toString(numbers));
		
		scanner.close();
		
		// second part
		
		Scanner input = new Scanner(System.in);
		
		int n = 0;
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			int number = Integer.parseInt(line);
			if (Arrays.binarySearch(numbers, number) >= 0) {
//				System.out.println(number);
				n++;
			}
		}
		
		System.out.println(n);

		input.close();
	}


}
