package lesson20241127;

public class ParameterizedUsage {
	
	public static void main(String[] args) {
		
		KIUList<String> list = new KIUList<String>();
		
		
		list.add("One");
		
		String removed = list.remove();
		
		
		KIUList<Integer> listOfIntegers = new KIUList<Integer>();
		
		listOfIntegers.add(new Integer(10));
		listOfIntegers.add(30);
		
		Integer removedInt = listOfIntegers.remove();
		int anotherInt = listOfIntegers.remove();
		
	}

}
