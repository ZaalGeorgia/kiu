package lesson250305.basics;

public class B extends Object {
	
	public static int global;
	public int instance;
	
	@Override
	public String toString() {
		return global + " " + instance;
	}
	
	public int getState() {
		return instance;
	}

}


