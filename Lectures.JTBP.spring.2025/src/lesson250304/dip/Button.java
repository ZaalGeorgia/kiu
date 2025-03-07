package lesson250304.dip;

public class Button {
	
	Switchable device;
	
	public Button(Switchable device) {
		this.device = device;
	}
	
	void press() {
		if (device.isOn()) 
			device.off();
		else 
			device.on();
	}

}