package lesson20241212;

import java.util.function.Consumer;

public class AndThenExample {
	
	public static void main(String[] args) {
		
		Consumer<String> c1 = (s) -> System.out.println(s);
		Consumer<String> c2 = (s) -> System.out.println(s.toUpperCase());
		
		Consumer<String> combination = 
				c1
				.andThen(c2)
				.andThen(c1)
				.andThen((s) -> {
					System.out.println(s.length());
				});
		
		combination.accept("Hello");
		
	}

}
