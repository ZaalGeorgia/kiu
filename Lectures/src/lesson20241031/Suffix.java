package lesson20241031;

public class Suffix implements Comparable<Suffix>{
	
	int start;
	String data;
	
	public Suffix(int begin, String original) {
		start = begin;
		data = original;
	}
	
	public int length() {
		return data.length() - start;
	}
	
	public char charAt(int pos) {
		return data.charAt(start + pos);
	}

	public String substring(int begin, int end) {
		return data.substring(start + begin, start + end);
	}
	
	public String toString() {
		return data.substring(start);
	}

	public int compareTo(Suffix otherSuffix) {
		return this.toString().compareTo(otherSuffix.toString());
	}

}
