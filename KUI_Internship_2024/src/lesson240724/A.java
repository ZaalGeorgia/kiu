package lesson240724;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class A {

	public void execute(String command) {
		Method[] methods = A.class.getMethods();

		FOUND: {
			for (Method method : methods) {
				if (command.equals(method.getName())) {
					try {
						method.invoke(this, null);
					} catch (IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
					break FOUND;
				}
			}
			System.out.println("unknown command");
			return;
		}
		System.out.println("processed");
	}

	public void one() {
		System.out.println("one");
	}

	public void two() {
		System.out.println("two");
	}

	public void three() {
		System.out.println("three");
	}
}