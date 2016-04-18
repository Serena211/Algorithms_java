package Class10_Recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Get all valid ways of putting N Queens on an N * N chessboard so that no two 
 * Queens threaten each other.
 * 
 * Assumptions
 * N > 0
 * 
 * Return
 * A list of ways of putting the N Queens
 * Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
 * 
 * Example
 * N = 4, there are two ways of putting 4 queens:
 * [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row 
 * is at y index 3, the Queen on the third row is at y index 0 and the Queen on the fourth 
 * row is at y index 2.
 * 
 * [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row 
 * is at y index 0, the Queen on the third row is at y index 3 and the Queen on the fourth 
 * row is at y index 1.
 */

public class NQueens {
	public List<List<Integer>> nqueens(int n) {
		List<List<Integer>> rsl = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		helper(rsl, cur, 0,n);
		return rsl;
	}

	private void helper(List<List<Integer>> rsl, List<Integer> cur, int index, int n) {
		// TODO Auto-generated method stub
		if (index == n) {
			rsl.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = 0; i < n; i++) {
			cur.add(i);
			if (isValid(cur)) {
				helper(rsl, cur, index+1, n);
			}
			cur.remove(cur.size() - 1);
		}
	}

	private boolean isValid(List<Integer> cur) {

		// TODO Auto-generated method stub
		for (int i = 0; i < cur.size() -1; i++) {
			if(cur.get(i) == cur.get(cur.size() - 1)) {
				return false;
			}
			if(Math.abs(i - cur.size() + 1) == Math.abs(cur.get(i) - cur.get(cur.size() - 1))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens sol = new NQueens();
		System.out.println(sol.nqueens(4));
	}

}
