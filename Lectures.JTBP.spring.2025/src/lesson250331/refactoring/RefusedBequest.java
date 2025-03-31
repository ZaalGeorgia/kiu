package lesson250331.refactoring;

public class RefusedBequest {
	
	public static void main(final String[] args) {
		
		RichParent parent = new RichParent();
		parent.doThis();
		parent.doThat();
		parent.doOther();
		
		PoorChild child = new PoorChild();
		child.doOther();
		
	}

}

class Another {
	public int z;
	
	public Another() {
	}
	
	public void doOther() {
		System.out.println("do other for all");
	}
}

class RichParent {
	
	int x;
	int y;
	Another z = new Another();

	void doThis() {}
	void doThat() {}
	void doOther() {
		z.doOther();
	}
	
}


class PoorChild  {
	Another z = new Another();
	
	void doOther() {
		z.doOther();
	}
}