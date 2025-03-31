package lesson250331.refactoring;

public class ReplaceSwitchSolution {
	
	public static void main(final String[] args) {
		
		process(new IA());
		
	}

	private static void process(final Original original) {
		original.doThree();
	}

}


class IA extends Original {
	@Override
	void doOne() {
		System.out.println("OneA");
	}
	
	@Override
	void doTwo() {
		System.out.println("TwoA");
	}
}

class IB extends Original {
}

class IC extends Original {
}

class ID extends Original {
}


class Original {
	static final int A = 0;
	static final int B = 1;
	static final int C = 2;
	static final int D = 3;
	
	int state = A;
	
	void doOne() {
		switch (state) {
		case A:
			break;
		case B:
			break;
		case C:
			break;

		default:
			break;
		}
	}
	
	void doTwo() {
		switch (state) {
		case A:
			break;
		case B:
			break;
		case C:
			break;
			
		default:
			break;
		}
		
	}
	
	void doThree() {
		System.out.println("Original Three");
	}
	
	
	
	
}