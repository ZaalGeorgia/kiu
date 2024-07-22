package lesson240718;

public class DecoratorExample {
	public static void main(String[] args) {
		Troll simple = new SimpleTroll();
		Troll complicated = new ComplicatedTroll();
		Troll dec1 = new ClubbedTroll(simple);
		Troll dec2 = new ClubbedTroll(complicated);
		
		dec1.attack();
		dec2.attack();
	}
}


interface Troll {
	void attack();
}

final class SimpleTroll implements Troll {
	@Override
	public void attack() {
		System.out.println("simple");
	}
	
}

final class ComplicatedTroll implements Troll {
	
	@Override
	public void attack() {
		System.out.println("complicated");
	}
	
}

class ClubbedTroll implements Troll {
	
	private Troll decorated;
	
	public ClubbedTroll(Troll decorated) {
		this.decorated = decorated;
	}

	@Override
	public void attack() {
		decorated.attack();
		System.out.println("Swing with the club");
	}
	
}