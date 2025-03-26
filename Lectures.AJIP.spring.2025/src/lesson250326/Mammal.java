package lesson250326;

public abstract class Mammal extends Animal {
	
	void produceMilk() {}
	
	@Override
	void eat() { // default implementation for all Mammals
		System.out.println("mammal eats");
	}

}
