package lesson250305.basics.singleton;

public class UseCache {
	
	public static void main(final String[] args) throws InterruptedException {
//		new MemoryCache();   NOT VISIBLE!
		
		System.out.println("start");
		
		Thread.sleep(10000);
		
		MemoryCache cache = MemoryCache.get();
		
		//...
		
		MemoryCache cache2 = MemoryCache.get();
		
		
	}

}
