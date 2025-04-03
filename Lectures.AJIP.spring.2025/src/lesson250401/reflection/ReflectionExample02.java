package lesson250401.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionExample02 {
	
	static Service service = new Service();

	public static void main(final String[] args) {
		
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				String command = scanner.nextLine();
				
				dispatch(command);
				
//				switch (command) {
//				case "LOAD":
//					service.load();
//				case "SAVE":
//					service.save();
//				case "UPDATE":
//					service.update();
//				}
			}
		}
		
	}

	private static void dispatch(final String command) {
		
		Class<Service> clazz = Service.class;
		try {
			Method method = clazz.getMethod(command.toLowerCase(), null);
			method.invoke(service, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


class Service {
	
	public void load() {
		System.out.println("LOAD");
	}
	
	public void save() {
		System.out.println("SAVE");
	}

	public void update() {
		System.out.println("UPDATE");
	}
	
}
