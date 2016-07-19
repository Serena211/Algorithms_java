package ex;

import java.util.Deque;
import java.util.LinkedList;

/*
 *  N is an integer within the range [0..200,000];
    string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

 * */
public class ProperlyNested {
	public int isProper(String input) {
		if (input == null || input.length() == 0) {
			return 1;
		}
		Deque<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < input.length(); i++) {
			if(stack.isEmpty() || !isPair(stack.peekFirst(), input.charAt(i))) {
				stack.offerFirst(input.charAt(i));
			} else if (isPair(stack.peekFirst(), input.charAt(i))) {
				stack.pollFirst();
			}
		}
		if (stack.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}
	private boolean isPair(Character a, Character b) {
		if (a == '(' && b == ')') {
			return true;
		}
		if (a == '[' && b == ']') {
			return true;
		}
		if (a == '{' && b == '}') {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		ProperlyNested sol = new ProperlyNested();
		System.out.println(sol.isProper("{[()()]}"));
	}

}
