package lesson20241029.oop;

public class CounterUsageExample {
	
	public static void main(String[] args) {
		var counter1 = new Counter();
		var counter2 = new Counter();
		
		counter1.passengerPassed();
		counter1.passengerPassed();
		counter1.passengerPassed();
		
		counter2.passengerPassed();
		counter2.passengerPassed();
		
		System.out.println(counter1.getCount());
		System.out.println(counter2.getCount());
	}

}
