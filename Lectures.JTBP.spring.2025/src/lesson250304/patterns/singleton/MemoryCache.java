package lesson250304.patterns.singleton;

public class MemoryCache {
	
//	static private MemoryCache instance = new MemoryCache()
	static private MemoryCache instance;
	
	private MemoryCache() {
	}

	public static MemoryCache instance() {
		if (instance == null) { // lazy instantiation
			instance = new MemoryCache();
		}
		return instance;
	}
	
	public String get(String s) {
		return "hello there";
	}

}
