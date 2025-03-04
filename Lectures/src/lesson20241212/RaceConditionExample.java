package lesson20241212;

import utils.Library;

public class RaceConditionExample {
	
	public static void main(String[] args) {
		Data data = new Data();
		
		new Thread(() -> {
			data.change(10);
		}).start();
		
		new Thread(() -> {
			data.change(10);
		}).start();
		
		System.out.println(data.check());
		System.out.println(data.x + ":" + data.y);
	}

}


class Data {
	int x;
	int y;
	
	void change(int diff) {
		x -= diff;
		Library.pause(100);
		y += diff;
	}
	
	boolean check() {
		return x + y == 0;
	}
}