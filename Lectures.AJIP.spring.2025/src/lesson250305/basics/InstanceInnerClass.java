package lesson250305.basics;

import lesson250305.basics.Thing.Part;

public class InstanceInnerClass {
	
	public static void main(final String[] args) {
		Animal animal = new Animal();
		Animal.Body body = new Animal.Body(animal);
		body.print();
		
		Thing thing = new Thing();
		Part part = thing.new Part();
		part.print();
	}

}

class Thing {
	
	private int thingBody = 10;
	
	class Part {
		int partChunk = 30;
		
		void print() {
			System.out.println(Part.this.partChunk + " " + Thing.this.thingBody);
		}
	}
}

class Animal {
	String paw = "left paw";
	
	static class Body {
		private Animal animal;
		public Body(final Animal animal) {
			this.animal = animal;
		}
		
		void print() {
			System.out.println("I may use " + animal.paw);
		}
		
	}
}