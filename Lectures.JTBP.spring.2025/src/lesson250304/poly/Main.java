package lesson250304.poly;

public class Main {
	
	public static void main(String[] args) {
		
		var table = new Table();
		
		var glass = new Glass();
		
		Breakable b = table;
		
		maintain(table);
		maintain(glass);
		
		paint(table);
		paint(new KitchenTable());

		staticMethod();
		
	}

	private static void paint(Table table) {
		System.out.println("painting " + table);
	}

	private static void staticMethod() {
		System.out.println("static");
	}

	private static void maintain(Breakable thing) {
		thing.breakIt();
	}

}
