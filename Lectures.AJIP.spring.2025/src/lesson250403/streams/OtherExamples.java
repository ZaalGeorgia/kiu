package lesson250403.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class OtherExamples {
	
	public static void main(String[] args) {
		
		long count = Dish.menu
		.stream()
		.filter(Dish::isVegetarian)
		.count();
		System.out.println(count);
		
		System.out.println();
		
		Dish.menu
		.stream()
		.filter(Dish::isVegetarian)
		.forEach(System.out::println);

		System.out.println();
		
		Dish.menu.stream()
		.filter(d -> !d.isVegetarian())
		.map(Dish::getType)
		.distinct()
		.forEach(System.out::println);
		
		Stream<String> argStream = Arrays.stream(args);

	}

}
