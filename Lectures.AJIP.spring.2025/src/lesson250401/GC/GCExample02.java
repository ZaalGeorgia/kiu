package lesson250401.GC;

import java.util.ArrayList;

public class GCExample02 {
	
	public static void main(final String[] args) throws InterruptedException {
		
		var list = new ArrayList<String>();
		
		int count = 0;
		
		while (true) {
			count++;
			list.add(Integer.toHexString(count));
			Thread.sleep(0, 10000);
			if (list.size() > 10000) {
				list.clear();
				System.gc();
				System.out.println("gc requested");
			}
		}
		
	}

}
