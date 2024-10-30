package lesson20241029.oop;

public class Counter {
	
	int count;   // state,  instance field
	
	void passengerPassed() {  // mutator
		count++;
	}
	
	int getCount() {  // get state
		return count;
	}

}
