package lesson20241126;

import java.util.Scanner;

public class KIUListExampleWithScanner {
	
	public static void main(String[] args) {
		
		var list = new KIUList(); // variable type is inferred by compiler
		
		System.out.println(list);

		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			list.add(line);
			System.out.println(list.size());
		}
		
		System.out.println(list);
		
		list.remove();
		
		System.out.println(list);
	}

}
