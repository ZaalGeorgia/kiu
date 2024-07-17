package lesson240717;

public class ShallowCopy {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		D d = new D(10);
		D copy = d.copy();
		
		System.out.println(d);
		System.out.println(copy);
		System.out.println(copy);
	}

}

class D implements Cloneable {
	int x;
	public D(int x) {
		this.x = x;
	}

	E e = new E();
	
	D copy() throws CloneNotSupportedException {
		D anotherD = new D(0);
		anotherD.x = this.x;
		return anotherD;
	}
	
	@Override
	public String toString() {
		return "D: " + x + ", " + e ;
	}
	
}

class E {
	int y = 20;
}
