package lesson20241212;

public class SwitchExample {
	
	
	public static void main(String[] args) {
		
		
		process(10);
		
	}

	private static void process(int age) {
		switch (age) {
		case 10: 
		case 11: 
		case 12: 
			System.out.println("young boy");
			break;
		case 20: 
			System.out.println("young man");
			break;
		case 50: 
			System.out.println("adult man");
			break;
		}
	}

}
