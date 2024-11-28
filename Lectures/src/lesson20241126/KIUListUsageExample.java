package lesson20241126;

public class KIUListUsageExample {
	
	public static void main(String[] args) {
		
		KIUList list = new KIUList();
		
		String removed = list.remove();
		
		System.out.println(removed);
		
		list.add("One");
		list.add("Two");
		list.add("Three");
		
		list.print();
		
		list.remove();
		
		list.print();
	}

}
