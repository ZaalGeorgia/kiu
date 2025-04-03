package lesson250403.streams;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamBasic {

  public static void main(String... args) {
    // Java 7
    getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

    System.out.println("---");

    // Java 8
    getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
  }

  public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
    List<Dish> lowCaloricDishes = new ArrayList<>();
    for (Dish d : dishes) {
      if (d.getCalories() < 400) {
        lowCaloricDishes.add(d);
      }
    }
    List<String> lowCaloricDishesName = new ArrayList<>();
    Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
      @Override
      public int compare(Dish d1, Dish d2) {
        return Integer.compare(d1.getCalories(), d2.getCalories());
      }
    });
    for (Dish d : lowCaloricDishes) {
      lowCaloricDishesName.add(d.getName());
    }
    return lowCaloricDishesName;
  }

  public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
	  	Stream<Dish> streamOfDishes = dishes.stream();
        Stream<Dish> lowCaloriesDishes = streamOfDishes.filter(d -> d.getCalories() < 400);
        Stream<Dish> sorted = lowCaloriesDishes.sorted(comparing(Dish::getCalories));
        Stream<String> names = sorted.map(Dish::getName);
        List<String> listOfNames = names.toList();
		return listOfNames;
  }

}
