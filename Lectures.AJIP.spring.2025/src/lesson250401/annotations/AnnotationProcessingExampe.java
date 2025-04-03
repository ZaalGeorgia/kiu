package lesson250401.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AnnotationProcessingExampe {
	
	static Service service = new Service();

	public static void main(final String[] args) {
		
//		Annotation[] annotations = service.getClass().getAnnotations();
//		
//		for (Annotation annotation : annotations) {
//			System.out.println(annotation);
//		}
		
		analyze(service.getClass());
		
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				String command = scanner.nextLine();
				
				dispatch(command);
			}
		}
				
	}

	private static void analyze(final Class<? extends Service> class1) {
		Method[] methods = class1.getMethods();
		
		for (Method method : methods) {
			System.out.println(method);
			Annotation[] annotations = method.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			System.out.println();
		}
	}

	private static void dispatch(final String command) {
		
		Class<Service> clazz = Service.class;
		try {
			Method method = clazz.getMethod(command.toLowerCase(), null);
			Command annotation = method.getAnnotation(Command.class);
			if (annotation == null) {
				System.err.println( command + " is not a command! use special annotation @Command");
				return;
			}
			method.invoke(service, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


class Service {
	
	@Command
	public void load() {
		System.out.println("LOAD");
	}
	
	@Command
	public void save() {
		System.out.println("SAVE");
	}

	@Command
	public void update() {
		System.out.println("UPDATE");
	}
	
	public void something() {
		
	}
	
}
