package officehour202411113;

import java.util.LinkedList;
import java.util.List;

public class Question02RuntimeErrorOutOfMemory {
	
	public static void main(String[] args) {
		
		List<String> strings = new LinkedList<>();
		
		while (true) {
			strings.add(new String("Hello"));
		}
		
		
	}
	

}
