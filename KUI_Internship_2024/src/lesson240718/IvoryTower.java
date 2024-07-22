package lesson240718;

public final class IvoryTower {
	
	static {
		System.out.println("static init");
	}

	private static final IvoryTower INSTANCE = new IvoryTower();
	

	private IvoryTower() {
		System.out.println("constructor");
	}


	public static IvoryTower getInstance(int data) {
		System.out.println("requesting INSTANCE");
		INSTANCE.setData(data);
		return INSTANCE;
	}
	
	private int data = 0;
	
	public void setData(int data) {
		this.data = data;
//		INSTANCE = new IvoryTower();  COMPILE ERROR!!!
	}

	{
		System.out.println("instance init");
	}
}