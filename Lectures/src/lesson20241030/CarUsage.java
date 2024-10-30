package lesson20241030;

import java.awt.Color;

public class CarUsage {
	
	public static void main(String[] args) {
		
		Car car1 = new Car();
		
		System.out.println(car1);
		System.out.println(car1.name);
		System.out.println(car1.enginePower);
		
		car1.name = "Mercedes";
		car1.enginePower = 3000;
		car1.maxSpeed = 250;
		car1.price = 50000;
		car1.color = new Color(0, 0, 0);
		
		car1.color = Color.RED;
		
		car1.paint(Color.BLUE);
		
		Car lamborgini = new Car(
				"Monster", 
				10000, 
				Color.GREEN, 
				100000, 
				400);
		
		System.out.println(lamborgini);
	}

}
