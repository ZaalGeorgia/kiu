package lesson250403.lambdas;

import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferences {
	
	public static void main(String[] args) {
		// (args) -> Classname.staticMethod(args)  ===> Classname::staticMethod
		Function<Integer, Integer> f=  Subject::staticmethod;
		
		//(args) -> expr.instanceMethod(args)     ===> expr::instanceMethod 

		Subject s = new Subject();
		
		Consumer<String> c = s::instance1;

		// (arg, rest) -> arg.instanceMethod(rest) ===> Classname::instanceMethod
        // Consumer<String> c = Subject::instance1;  why?
	}

}

class Subject {
	
	static int staticmethod(int x) {
		return 0;
	}
	
	void instance1(String param) {
		System.out.println(param);
	}
	
}
