package Class03_List;

import java.util.LinkedList;

/*
 * Enhance the stack implementation to support min() operation. min() should 
 * return the current minimum value in the stack. If the stack is empty, min() 
 * should return -1.
 * 
 * pop() - remove and return the top element, if the stack is empty, return -1
 * 
 * push(int element) - push the element to top
 * top() - return the top element without remove it, if the stack is empty, return -1
 * min() - return the current min value in the stack.
 * 
 */
public class StackWithMin {
	private LinkedList<Integer> stack;
	private LinkedList<Integer> min;
	public StackWithMin() {
		stack = new LinkedList<Integer>();
		min = new LinkedList<Integer>();
	}

	public int pop() {
		if (stack.isEmpty()) {
			return -1;
		}
		if (stack.peekFirst() == min.peekFirst()) {
			min.pollFirst();
		}
		return stack.pollFirst();
	}

	public void push(int element) {
		stack.offerFirst(element);
		if (min.isEmpty() || min.peekFirst() >= element) {
			min.offerFirst(element);
		}
	}

	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peekFirst();
	}

	public int min() {
		if (!min.isEmpty()) {
			return min.peekFirst();
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
