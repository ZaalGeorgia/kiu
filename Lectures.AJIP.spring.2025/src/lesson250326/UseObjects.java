package lesson250326;

public class UseObjects {
	
	public static void main(final String[] args) {
		
		Object o;
		
		Animal a;
		
		Mammal m;
		Bird b;
		
		Dog d;
		Chiken c;
		
		d = new Dog();
		d.toString();
		d.bark();
		d.produceMilk();
		d.eat();
		
		c = new Chiken();
		d.toString();
		c.hasWings();
		c.makeEgg();
		c.eat();
		
		m = d;
		m.eat();
		m.produceMilk();
//		m.bark();  COMPILE ERROR!
		
//		m = c;  COMPILE ERROR!
		
		a = m;
		
		a = c;
		
		o = a;
		o = d;
		o = c;
		
		
		CanFly flyingObject = new Drone();
		CanFly flyingObject2 = new Duck();
		CanFly flyingObject3 = new FlyingSquirrel();
		
		Animal a2 = new Duck();
		
		process(flyingObject);
		process(flyingObject2);
		process(flyingObject3);
		process(flyingObject3);
//		process(a2); COMPILE ERROR!
		
//		Animal a3 = new Animal();  COMPILE ERROR!
	}

	private static void process(final CanFly flyingObject) {
		flyingObject.fly();
		flyingObject.hashCode();
	}

}
