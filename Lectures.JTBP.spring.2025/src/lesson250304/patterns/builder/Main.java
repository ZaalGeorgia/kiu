package lesson250304.patterns.builder;

public class Main {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("one");
		sb.append(2);
		sb.append('\n');

		String result = sb.toString();
		
		System.out.println(result);

		System.out.println(sb.toString());
		System.out.println(sb.toString());
		System.out.println(sb.toString());
		
		
	}

}
