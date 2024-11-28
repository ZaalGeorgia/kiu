package lesson20241126;

public class KIUList {
	
	Node first = null;
	Node last = null;
	int size = 0;
	
	void add(String item) {
		Node newNode = new Node(item);
		size++;
		if (first == null) {
			first = last = newNode;
			return;
		}
		last.next = newNode;
		last = newNode;
	}

	String remove() {
		if (first == null) {
			return null;
		}
		String firstValue = first.item;
		first = first.next;
		return firstValue;
	}
	
	@Override
	public String toString() {
		String result = "";
		Node current = first;
		while (current != null) {
			result += current.item + ", ";
			current = current.next;
		}
		return result;
	}

	void print() {
		System.out.println(toString());
	}

	public int size() {
		return size;
	}
}