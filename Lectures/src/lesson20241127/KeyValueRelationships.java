package lesson20241127;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class KeyValueRelationships {
	
	
	public static void main(String[] args) {
		
		
//		Map<String, String> map = new HashMap<>();  No Order
//		Map<String, String> map = new LinkedMap<>();  Preserves adding order
		Map<String, String> map = new TreeMap<>();  // Sorted
		
		map.put("Jane", "cat");
		map.put("Kate", "dog");
		map.put("Pete", "bird");
		map.put("Jack", "dragon");
		
		System.out.println(map);
		
		map.get("Kate");
		map.get("Jane");
		
		Map<Integer, String> map2 = new HashMap<>();
		
		map2.put(1, "One");
		map2.put(2, "Two");
		
		
		System.out.println(map2.get(2));
		
	}

}
