package Class06_Graph2;

import java.util.ArrayList;
import java.util.List;

/*
 * Given N pairs of parentheses “()”, return a list with all the valid permutations.
 * 
 * Assumptions
 * N >= 0
 * 
 * Examples
 * N = 1, all valid permutations are ["()"]
 * N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * N = 0, all valid permutations are [""]
 * 
 * */

public class AllValidPermutationsOfParentheses {
	public List<String> validParentheses(int n) {
		List<String> rsl = new ArrayList<String>();
		StringBuilder temp = new StringBuilder();
		helper(temp, n, 0, 0, rsl);
		return rsl;
	}
	private void helper(StringBuilder temp, int n, int r, int l, List<String> rsl) {
		if(l == n && r == n) {
			rsl.add(temp.toString());
			return;
		}
		if (l < n) {
			temp.append('(');
			helper(temp, n, r, l+1, rsl);
			temp.deleteCharAt(temp.length() - 1);
		}
		if (r < l) {
			temp.append(')');
			helper(temp, n, r+1, l, rsl);
			temp.deleteCharAt(temp.length() - 1);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
