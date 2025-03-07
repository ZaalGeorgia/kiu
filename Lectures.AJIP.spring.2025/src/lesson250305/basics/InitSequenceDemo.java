package lesson250305.basics;

public class InitSequenceDemo {
	
	public static void main(final String[] args) {
		One one = new One();
	}
	
}

class One {
	
	static Two two = new Two();
	
	static {
		
	}
	
}


class Two {
	{
		System.out.println("initialized two");
	}
	
}