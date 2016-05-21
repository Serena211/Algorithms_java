package Class24;

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
		// base case:
//		len[1] = s.charAt(0) == '(' && s.charAt(1) == ')' ? 1 : 0;
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else if (left > right && s.charAt(i) == ')') {
				right++;
			} else 
			len[i] = 0;
		}
		return right * 2;
	}

	public static void main(String[] args) {
		LongestValidParentheses sol = new LongestValidParentheses();
		String input = new String("(()");
		System.out.println(sol.longestValidParentheses(input));
	}

}
