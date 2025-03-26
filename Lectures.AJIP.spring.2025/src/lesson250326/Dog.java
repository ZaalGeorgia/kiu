package lesson250326;

public class Dog extends Mammal {
	
	void bark() {}
	
	@Override
	void eat() {
		System.out.println("before");
		super.eat();
		System.out.println("after");
	}

}
