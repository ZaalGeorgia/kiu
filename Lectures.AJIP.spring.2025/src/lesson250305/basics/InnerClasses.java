package lesson250305.basics;

public class InnerClasses {
	
	public static void main(final String[] args) {

		Outer outer = new Outer();
		Outer.SInner sinner = new Outer.SInner();
		Outer.Inner inner = outer.new Inner();
	}
	

}
