package Class24;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given a string containing just the characters '(' and ')', find the length of the 
 * longest valid (well-formed) parentheses substring.
 * 
 * Example:
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * For ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		int[] len = new int[s.length()];
		Deque<Character> stack = new LinkedList<Character>();
		// base case:
		len[0] = 0;
		stack.offerFirst(s.charAt(0));
//		len[1] = s.charAt(0) == '(' && s.charAt(1) == ')' ? 1 : 0;
//		int left = 0;
//		int right = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.offerFirst('(');
				len[i] = len[i-1];
			} else {
				if (s.charAt(i) == ')' && stack.peekFirst() == '(') {
					len[i] = len[i - 1] + 1;
				}
			}
		}
		return len[s.length() - 1];
	}

	public static void main(String[] args) {
		LongestValidParentheses sol = new LongestValidParentheses();
		String input = new String("(()");
		System.out.println(sol.longestValidParentheses(input));
	}

}
