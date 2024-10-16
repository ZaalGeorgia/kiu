package lesson20241003.functions;

public class FormalAndActualParamters2 {
	
	public static void main(String[] args) {
		
		int i;
		
		i = 20;
		
		// i = 30;  ERROR - final variable, can't change the value
		
//		set10(i);
		set10(i);
		
		System.out.println(i);
	}

	static void set10(int param) { // int i = 20
		 param = 10; 
	}

}
