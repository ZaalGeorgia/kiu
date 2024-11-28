package lesson20241127;

public class KIUList<T> {
	
	private static class Node<T> {  // nested
		T item;
		Node<T> next;

		public Node(T item) {
			this.item = item;
		}
	}
	
	
	private Node<T> first = null;
	private Node<T> last = null;
	private int size = 0;
	
	public void add(T item) {
		Node<T> newNode = new Node<T>(item);
		size++;
		if (first == null) {
			first = last = newNode;
			return;
		}
		last.next = newNode;
		last = newNode;
	}

	public T remove() {
		if (first == null) {
			return null;
		}
		T firstValue = first.item;
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

	public void print() {
		System.out.println(toString());
	}

	public int size() {
		return size;
	}
}