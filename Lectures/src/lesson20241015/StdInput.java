package lesson20241015;

import std.StdIn;
import std.StdOut;

public class StdInput {
	
	public static void main(String[] args) {
		
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			StdOut.println(line);
		}
		
	}

}
