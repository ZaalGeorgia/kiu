package lesson250331.refactoring;

public class PrimitiveObsessionBad {
	
	public static void main(final String[] args) {
		
		process(1);
		process(2);
		process(3);
		
	}

	private static void process(final int command) {
		switch (command) {
		case 1: 
			System.out.println("LOAD");
			break;
		case 2: 
			System.out.println("SAVE");
			break;
		case 3: 
			System.out.println("UPDATE");
			break;
		}
		
	}

}
