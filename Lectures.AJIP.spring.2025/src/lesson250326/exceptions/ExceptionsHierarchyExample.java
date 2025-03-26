package lesson250326.exceptions;

import java.util.Random;

public class ExceptionsHierarchyExample {

	static Random r = new Random();
	
	public static void main(final String[] args) {
		
		try {
			process();
		} catch (Another e) {
			System.out.println("another");
		} catch (OtherEx e) {
			System.out.println("other");
		} catch (MyEx e) {
			System.out.println("my");
		} catch (Exception e) {
			System.out.println("exception");
		} finally {
			System.out.println("finally");
		}
		
	}

	private static void process() throws Exception {
		Exception[] exs = {new Another(), new MyEx(), new OtherEx(), new Exception()};
		throw exs[r.nextInt(exs.length)]; 
	}

}

class MyEx extends Exception {
	
}

class OtherEx extends MyEx {
	
}

class Another extends OtherEx {
	
}
