package Class99_Mix;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but 
 * "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s ==  null || s.length() == 0 || s.length() % 2 == 1) {
			return false;
		}
		char[] input = s.toCharArray();
		Deque<Character> stack = new LinkedList<Character>();
		for (char c : input) {
			if (stack.isEmpty()) {
				stack.offerFirst(c);
			} else {
				if ((stack.peekFirst() == '(' && c == ')') 
						|| (stack.peekFirst() == '[' && c == ']') 
						|| (stack.peekFirst() == '{' && c == '}')) {
					stack.pollFirst();
				} else {
					stack.offerFirst(c);
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses sol = new ValidParentheses();
		System.out.println(sol.isValid("[({(())}[()])]"));
	}

}
