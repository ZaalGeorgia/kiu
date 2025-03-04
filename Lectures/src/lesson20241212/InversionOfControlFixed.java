package lesson20241212;

public class InversionOfControlFixed {
	
	public static void main(String[] args) {
		
		GoodSwitch goodSwitch = new GoodSwitch(new AnotherLamp());
		
		goodSwitch.toggle();
		
		GoodSwitch goodSwitch2 = new GoodSwitch(new Fridge());
		goodSwitch2.toggle();
	}

}

interface Switchable {

	boolean isOn();

	void on();

	void off();

}

class GoodSwitch {
	
	Switchable device;
	
	public GoodSwitch(Switchable device) {
		this.device = device;
	}
	
	void toggle() {
		if (device.isOn()) {
			device.off();
		} else {
			device.on();
		}
	}
	
}


class AnotherLamp implements Switchable {
	boolean on = false;

	@Override
	public boolean isOn() {
		return on;
	}

	@Override
	public void on() {
		on = true;
	}

	@Override
	public void off() {
		on = false;
	}
	
	
}


class Fridge implements Switchable {

	@Override
	public boolean isOn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		
	}
	
}
