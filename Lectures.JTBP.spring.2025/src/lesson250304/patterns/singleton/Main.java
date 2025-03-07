package lesson250304.patterns.singleton;

public class Main {
	
	public static void main(String[] args) {
		
		MemoryCache mc = MemoryCache.instance();
		
		String result = mc.get("hello");
		
		System.out.println(result);
		
	}

}
