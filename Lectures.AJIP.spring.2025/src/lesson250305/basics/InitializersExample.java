package lesson250305.basics;

public class InitializersExample {
	
	public InitializersExample() {
		System.out.println("constructor");
	}
	
	public InitializersExample(int param) {
		System.out.println("param: " + param);
	}
	
	
	{
		System.out.println("instance");
	}
	
	static {
		System.out.println("static");
	}
	
	public static void main(String[] args) {
		InitializersExample ie = new InitializersExample();
		InitializersExample ie2 = new InitializersExample(10);
	}

}
