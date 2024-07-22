package lesson240718;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SingletonUsageExample {
	
	public static void main(String[] args) throws InterruptedException {
		IvoryTower it;
		System.out.println(IvoryTower.class);
		
		System.out.println("starting service");
		
		Thread.sleep(5000);
		
		System.out.println("trying to use IvoryTower singleton");
		IvoryTower.getInstance(10);
		IvoryTower.getInstance(20);
		IvoryTower.getInstance(30);
		
		System.out.println(IvoryTower.getInstance(0));
		
		System.out.println(IvoryTower.class);
		System.out.println(SingletonUsageExample.class);
		
		Method[] methods = IvoryTower.class.getMethods();
		System.out.println(Arrays.toString(methods));
	}

}
