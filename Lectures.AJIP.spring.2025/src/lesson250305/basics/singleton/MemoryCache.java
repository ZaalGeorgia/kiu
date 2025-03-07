package lesson250305.basics.singleton;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache {
	
	
	private static MemoryCache instance = new MemoryCache();
	
	public static MemoryCache get() {
		System.out.println("getting reference to cache");
		return instance;
	}
	
	Map<String, String> cache = new HashMap<>();
	
	private MemoryCache() {
		System.out.println("constructor");
	}

	static {
		System.out.println("static init");
	}
}
