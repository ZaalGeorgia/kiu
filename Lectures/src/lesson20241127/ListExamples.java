package lesson20241127;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ListExamples {
	
	public static void main(String[] args) {

		List<String> list;
		
		list = new LinkedList<>();
		
		list.add("One");
		
		
		List<String> list2;
		
		list2 = new ArrayList<>();
		
		
		
		

		Queue<String> d2 = new LinkedList<>();
		
		//  FIFO - first in, first out
		
		d2.add("One");
		d2.add("Two");
		
		System.out.println(d2.remove());
		
		
		
	  // LIFO  last in,  first out
		
		Stack<String> s = new Stack<>();
		
		s.push("One");
		s.push("Two");
		
		System.out.println(s.pop());

		
		Deque<String> d = new LinkedList<>();
		
		d.add("One");
		d.add("Two");
		
		System.out.println(d);
		
	}

}
