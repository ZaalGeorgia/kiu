package lesson250401.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {
	
	public static void main(final String[] args) {
		Object o = new Object();
		A a = new A();
		a.x();
		Class<A> clazz = A.class;
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		try {
			Method method = clazz.getMethod("x", null);
			method.invoke(a, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}

class A {
	
	public void x() {
		System.out.println("x");
	}

	public void y() {
		System.out.println("y");
	}
	
}
