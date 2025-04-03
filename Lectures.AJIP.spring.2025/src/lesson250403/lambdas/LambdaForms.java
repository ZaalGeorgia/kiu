package lesson250403.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaForms {
	
	public static void main(String[] args) {
		
		Runnable r = () -> {
			System.out.println();
		};
		
		Consumer<String> c = (String s) -> {
			System.out.println(s);
		};
		
		c.accept("hello");
		
		Consumer<String> c2 = (s) -> {
			System.out.println(s);
		};
		
		Consumer<String> c3 = s -> {
			System.out.println(s);
		};
		
		Function<String, Integer> f1 = s -> {return 0;};
		Function<String, Integer> f2 = s -> 0;
		Function<String, Integer> f3 = s -> s.length();
		Function<String, Integer> f4 = String::length;
		
		
	}

}
