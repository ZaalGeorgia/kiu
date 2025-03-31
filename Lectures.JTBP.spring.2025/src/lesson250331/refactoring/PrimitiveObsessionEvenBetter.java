package lesson250331.refactoring;

public class PrimitiveObsessionEvenBetter {
	
	enum Command {
		LOAD, SAVE, UPDATE;
	}
	
	public static void main(final String[] args) {
		
		process(Command.LOAD);
		process(Command.SAVE);
		process(Command.UPDATE);
		
	}

	private static void process(final Command load) {
		switch (load) {
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
