package lesson20240917;

public class ExchangeTwoNumbers {

	public static void main(String[] args) {
		int a = 1234;
		int b = 99;
		int t = a;
		a = b;
		b = t;
		
		System.out.println(a);
		System.out.println(b);
	}

}
