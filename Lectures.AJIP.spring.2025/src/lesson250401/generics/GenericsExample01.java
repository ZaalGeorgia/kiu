package lesson250401.generics;

public class GenericsExample01 {
	
	public static void main(final String[] args) {
		var stack = new Stack<String>();
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push(Integer.toString(2));
		
		process(stack.pop());
		process(stack.pop());
		process(stack.pop());
		process(stack.pop());
		
		var intStack = new Stack<Integer>();
		
		intStack.push(2);
//		intStack.push(2.0);  COMPILE ERROR!
//		intStack.push("2");  COMPILE ERROR!
	}

	private static void process(final Object data) {
		if (data instanceof String s) {
			System.out.println("length: " + s.length());
		}
		if (data instanceof Integer i) {
			System.out.println("int " + i);
		}
		
	}
		

}

class Stack<E> {

	private static class Node<E> {
		public Node(final E item, final Node<E> next) {
			s = item;
			this.next = next;
		}
		E s;
		Node<E> next;
	}
	
	Node<E> top;
	
	void push(final E item) {
		top = new Node<E>(item, top);
	}
	
	E pop() {
		if (top == null) {
			return null;
		}
		E result = top.s;
		top = top.next;
		return result;
	}
}