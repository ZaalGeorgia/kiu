package lesson20240821;

public class Data {
	int x, y;
	
	void changeState(int diff) {
		x += diff;
		y -= diff;
	}
	
	boolean check() {
		return x + y == 0;
	}
}