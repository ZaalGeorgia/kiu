package lesson250401.GC;

import utils.Utils;

public class GCExample03 {
	
	public static void main(final String[] args) {
		String r;
		
		while (true) {
			r = makeObject();
			// do something with r
			r = null;
			// some other intensive calculations
			
		}
		
	}

	private static String makeObject() {
		String result = new String("ABC");
		// do something other
		Utils.pause(10000);
		return result;
	}

}
