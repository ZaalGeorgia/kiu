package lesson250305.basics;

public class OldFashion {
	
	public static void main(final String[] args) {
		Data data = new Data();
		
		Code.change(data, 100);
		
	}

}

class Data {
	int i;
	int j;
}

class Code {
	
	static void change(final Data d, final int shift) {
		d.i += shift;
		d.j -= shift;
	}
	
	
}