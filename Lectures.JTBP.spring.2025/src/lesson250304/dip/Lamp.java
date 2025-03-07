package lesson250304.dip;

public class Lamp implements Switchable {
	
	boolean isOn = false;

	@Override
	public boolean isOn() {
		return isOn;
	}

	@Override
	public void off() {
		isOn = false;
	}

	@Override
	public void on() {
		isOn = true;
	}

}
