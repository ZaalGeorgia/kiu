package lesson250326;

public class Duck extends Bird implements CanFly {

	@Override
	public void fly() {
		
	}

	@Override
	void eat() {
		System.out.println("eating in duck style");
	}
	

}
