package lesson250403.streams;

import java.util.stream.Stream;

import utils.Utils;

public class HighCaloriesNames {

	public static void main(String[] args) {
		System.out.println("start processing");
		Stream<String> streamOfNames = Dish.menu.stream().filter(dish -> {
			System.out.println("filtering " + dish.getName());
			return dish.getCalories() > 300;
		}).map(dish -> {
			System.out.println("mapping " + dish.getName());
			return dish.getName();
		}).limit(3);
		Utils.pause(5000);
		System.out.println(streamOfNames.toList());
	}

}
