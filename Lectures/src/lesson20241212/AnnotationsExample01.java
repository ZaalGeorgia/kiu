package lesson20241212;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationsExample01 {
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

		MySample mySample = new MySample();
		
//		Class<? extends MySample> clazz = mySample.getClass();
		Class<? extends MySample> clazz = MySample.class;
		
		System.out.println(clazz);
		
		for (Method method : clazz.getDeclaredMethods()) {
			System.out.println(method);
			if (method.isAnnotationPresent(Sample.class)) {
				method.invoke(mySample, null);
			}
		}
		
		
	}
	

}


class MySample {
	
	@Sample
	void aSample() {
		System.out.println("this is a sample");
	}
	
	void notASample() {
		System.out.println("this is not a sample");
	}
}