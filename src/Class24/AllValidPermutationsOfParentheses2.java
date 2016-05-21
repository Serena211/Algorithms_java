package Class24;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Get all valid permutations of l pairs of (), m pairs of [] and n pairs of {}.
 * 
 * Assumptions
 * l, m, n >= 0
 * 
 * Examples
 * l = 1, m = 1, n = 0, all the valid permutations are ["()[]", "([])", "[()]", "[]()"]
 */
public class AllValidPermutationsOfParentheses2 {
	public List<String> validParentheses(int l, int m, int n) {
		List<String> rsl = new ArrayList<String>();
		int[] left = new int[]{l,m,n};
		int[] right = new int[]{l,m,n};
		Deque<Character> stack = new LinkedList<Character>();
		char[] sol = new char[2 * (l + m + n)];
		helper(left, right, stack, rsl, sol, 0);
		return rsl;
	}

	private void helper(int[] left, int[] right, Deque<Character> stack,
			List<String> rsl, char[] sol, int index) {
		if ( index == sol.length) {
			rsl.add(new String(sol));
			return;
		}
		if (left[0] > 0) {
			sol[index] = '(';
			left[0] -= 1;
			stack.offerFirst('(');
			helper(left, right, stack, rsl, sol, index + 1);
			stack.pollFirst();
			left[0] += 1;
		}
		if (right[0] > left[0]) {
			if (stack.peekFirst().equals('(')) {
				sol[index] = ')';
				right[0] -= 1;
				char temp = stack.pollFirst();
				helper(left, right, stack, rsl, sol, index + 1);
				stack.offerFirst(temp);
				right[0] += 1;
			}
		}
		
		if (left[1] > 0) {
			sol[index] = '[';
			left[1] -= 1;
			stack.offerFirst('[');
			helper(left, right, stack, rsl, sol, index + 1);
			stack.pollFirst();
			left[1] += 1;
		}
		if (right[1] > left[1]) {
			if (stack.peekFirst().equals('[')) {
				sol[index] = ']';
				right[1] -= 1;
				char temp = stack.pollFirst();
				helper(left, right, stack, rsl, sol, index + 1);
				stack.offerFirst(temp);
				right[1] += 1;
			}
		}

		if (left[2] > 0) {
			sol[index] = '{';
			left[2] -= 1;
			stack.offerFirst('{');
			helper(left, right, stack, rsl, sol, index + 1);
			stack.pollFirst();
			left[2] += 1;
		}
		if (right[2] > left[2]) {
			if (stack.peekFirst().equals('{')) {
				sol[index] = '}';
				right[2] -= 1;
				char temp = stack.pollFirst();
				helper(left, right, stack, rsl, sol, index + 1);
				stack.offerFirst(temp);
				right[2] += 1;
			}
		}
		
	}

	public static void main(String[] args) {
		AllValidPermutationsOfParentheses2 sol = new AllValidPermutationsOfParentheses2();
		System.out.println(sol.validParentheses(3, 2, 1));
	}

}
