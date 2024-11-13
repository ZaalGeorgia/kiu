package lesson20241112;

public class LocalVsInstanceVariable {
	
	public static void main(String[] args) {
		A a = new A();
		
		System.out.println(a.m);
		System.out.println(a.s);
	}

}

class A {
	
	int m;  // field, or instance variable
	String s;

	void m() {

//		System.out.println(i); ERROR!  i does not exist yet!

		int i = 0;
		{
			int j;

			j = 10;
		}
		
		do {
			int k = 10;
			break;
		} while (true);
		
//		System.out.println(i + j); ERROR:  j is out of scope here, not available
	}
}