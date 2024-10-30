package lesson20241030;

import java.awt.Color;

public class Car {
	
	String name;
	int enginePower;
	Color color;
	int price;
	int maxSpeed;
	
	Car() {}

	public Car(String name, int enginePower, Color color, int price, int maxSpeed) {
		super();
		this.name = name;
		this.enginePower = enginePower;
		this.color = color;
		this.price = price;
		this.maxSpeed = maxSpeed;
	}

	
	void paint(Color newColor) {
		color = newColor;
		price = price + 1000;
	}

}
