package lesson20241212;

public class InversionOfControl {
	
	public static void main(String[] args) {
		
		Switch s = new Switch();
		
		s.toggle();
	}

}

class Switch {
	Lamp lamp = new Lamp();
	
	void toggle() {
		if (lamp.isOn()) {
			lamp.off();
		} else {
			lamp.on();
		}
	}
	
}


class Lamp {
	boolean on = false;

	public boolean isOn() {
		return on;
	}

	public void on() {
		on = true;
	}

	public void off() {
		on = false;
	}
	
	
	
}