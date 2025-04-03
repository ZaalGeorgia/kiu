package lesson250403.lambdas;

import java.util.function.Supplier;

import utils.Utils;

public class SupplierExample {
	
	public static void main(String[] args) {
		
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		
		Supplier<Animal> s = Cat::new;

		process(s);
		
	}

	private static void process(Supplier<Animal> s) {
		Utils.pause(2000);
		s.get();
	}

}

interface Animal {
	
}

class Cat implements Animal {
	{
		System.out.println("cat was just created");
	}
}

class Dog implements Animal {
	
}
