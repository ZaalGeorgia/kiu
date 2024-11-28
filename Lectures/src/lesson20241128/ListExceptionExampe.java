package lesson20241128;

public class ListExceptionExampe {
	
	public static void main(String[] args) {
		
		var list = new KIUListWithExceptions<String>();
		
		String removed;
		
		try {
			removed = list.remove();
		} catch (Exception e) {
			e.printStackTrace();
			removed = "";
		}
		
	}

}
