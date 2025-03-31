package lesson250331.refactoring;

public class LongParameterListGood {
	
	public static class ParameterObject {
		public int x;
		public int y;
		public String title;
		public int data;
		
		public ParameterObject(final int x, final int y, final String title, final int data) {
			this.x = x;
			this.y = y;
			this.title = title;
			this.data = data;
		}
	}
	
	public static void main(final String[] args) {
		
		int x = 10;
		int y = 20;
		
		process(new ParameterObject(x, y, null, 30));
		
		
	}

	private static void process(final ParameterObject p) {
		System.out.println(p.x);
	}

}
