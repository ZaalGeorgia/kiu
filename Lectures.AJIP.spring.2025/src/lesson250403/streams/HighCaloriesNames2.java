package lesson250403.streams;

import java.util.stream.Stream;

import utils.Utils;

public class HighCaloriesNames2 {

	public static void main(String[] args) {
		System.out.println("start processing");
		Stream<String> streamOfNames = 
				Dish.menu.stream()
				.filter(dish -> dish.getCalories() > 300)
				.peek(System.out::println)
				.map(Dish::getName)
				.peek(System.out::println)
				.limit(1);
		Utils.pause(5000);
		System.out.println(streamOfNames.toList());
	}

}
