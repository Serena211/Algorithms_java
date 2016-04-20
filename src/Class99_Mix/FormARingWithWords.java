package Class99_Mix;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given an array of strings, find if the strings can be concatenated to form a ring. 
 * The two strings s1 and s2 can be concatenated iff the the last char of s1 is identical 
 * to the first char of s2. The first char of the first string in the array must be 
 * identical to the last char of the last string. The ring must contain every string in 
 * the input once and only once.
 * 
 * Assumptions:
 * The given array is not null or empty.
 * None of the strings in the array is null or empty.
 * 
 * Examples:
 * input = {"aaa", "bbb", "baa", "aab"}, return true since it can be re-arranged to 
 * 		   {"aaa", "aab", "bbb"  and "baa"}
 * input = {"aaa", "bbb"}, return false
 */
public class FormARingWithWords {
	public boolean formRing(String[] input) {
		if (input.length == 1) {
			return false;
		}
		Deque<Character> stack = new LinkedList<Character>();
		return helper(input, stack, 0);
		
//		if (input.length == 1) {
//			return false;
//		}
//		Deque<Character> stack = new LinkedList<Character>();
//		char first = input[0].charAt(0);
//		stack.offerFirst(input[0].charAt(0));
//		stack.offerFirst(input[0].charAt(input[0].length() - 1));
//		for (int i = 1; i < input.length; i++) {
//			if (input[i].charAt(0) != stack.peekFirst()) {
//				return false;
//			}
//			stack.pollFirst();
//			stack.offerFirst(input[i].charAt(input[i].length() - 1));
//		}
//		if (first == stack.peekFirst()) {
//			return true;
//		}
//		return false;
	}

	private boolean helper(String[] input, Deque<Character> stack, int index) {
		// TODO Auto-generated method stub
		if (index == input.length) {
			return true;
		}
		
		if (index == 0) {
			stack.offerFirst(input[index].charAt(0));
			stack.offerFirst(input[index].charAt(input[index].length() - 1));
			helper(input, stack, index + 1);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FormARingWithWords sol = new FormARingWithWords();
		String[] t = new String[] { "aaa", "bbb" };
		System.out.println(sol.formRing(t));
	}

}
