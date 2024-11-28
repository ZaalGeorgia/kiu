package lesson20241128;

import java.util.Stack;

import std.StdIn;
import std.StdOut;

public class Postfix {
	public static void main(String[] args) {
		Stack<Double> stack = new Stack<Double>();
		while (!StdIn.isEmpty()) {
			String token = StdIn.readString();
			if (token.equals("*"))
				stack.push(stack.pop() * stack.pop());
			else if (token.equals("+"))
				stack.push(stack.pop() + stack.pop());
			else if (token.equals("-"))
				stack.push(-stack.pop() + stack.pop());
			else if (token.equals("/"))
				stack.push((1.0 / stack.pop()) * stack.pop());
			else if (token.equals("sqrt"))
				stack.push(Math.sqrt(stack.pop()));
			else
				stack.push(Double.parseDouble(token));
		}
		StdOut.println(stack.pop());
	}
}