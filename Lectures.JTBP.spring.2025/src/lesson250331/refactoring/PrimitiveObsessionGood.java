package lesson250331.refactoring;

public class PrimitiveObsessionGood {
	
	private static final int LOAD = 1;
	private static final int SAVE = 2;
	private static final int UPDATE = 3;

	public static void main(final String[] args) {
		
		process(LOAD);
		process(SAVE);
		process(UPDATE);
		
	}

	private static void process(final int command) {
		switch (command) {
		case LOAD: 
			System.out.println("LOAD");
			break;
		case SAVE: 
			System.out.println("SAVE");
			break;
		case UPDATE: 
			System.out.println("UPDATE");
			break;
		}
		
	}

}
