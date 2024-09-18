package lesson20240917;

public class Conversions {
	
	public static void main(String[] args) {
		String binary = Integer.toBinaryString(255);
		System.out.println(binary);
		
		System.out.println(Integer.toHexString(255));
	}

	// 1024 = 2**10   kilobyte
	// 1024 * 1024 = 2**20  - megabyte
	// 1024 * 1024 * 1024 = 2**30  - gigabyte
}
