package lesson20241031.closed;

public class A {
	
	private int state;
	
	public void change() {
		state++;
	}
	
	void helper() {
		state += 10;
		anotherHelper();
	}
	
	private void anotherHelper() {
		state *= 10;
	}

}
