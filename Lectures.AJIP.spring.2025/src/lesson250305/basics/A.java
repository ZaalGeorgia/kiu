package lesson250305.basics;

public class A {
	
	static class T { // static inner
		
	}
	
	static { // static init
		
	}
	
	{ // inner init
		
	}
	
	class B { // inner
		class C {
			
		}
	}
	
	static public int MAX = 100;
	
	String name;
	boolean isTrue;
	int size;
	
	
	public A() {
		
		Runnable r = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
	}
	
	public String getName( ) {
		String surname;
		
		
//		return name + surname;  ERROR!
		return name;
	}
	
	public String A() {
		
		return "";
	}
	
	Runnable getFunction() {
		class Task implements Runnable {

			@Override
			public void run() {
				
			}
			
		}
		
		return new Task();
	}
	
	

}
