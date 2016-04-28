package Class99_Mix;

/*
 * There are in total n steps to climb until you can reach the top. You can climb 1 
 * or 2 steps a time. Determine the number of ways you can do that.
 * 
 * Example:
 * Input: n = 4, Return 5.
 */

public class ClimbingStairs {
	public int stairs(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n <= 2) {
			return n;
		}
		// base case: M[1] = 1; M[2] = 2
		int[] M = new int[n + 1];
		M[1] = 1;
		M[2] = 2;
		for (int i = 3; i < M.length; i++) {
			M[i] = M[i - 1] + M[i - 2];
		}
		return M[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs sol = new ClimbingStairs();
		System.out.println(sol.stairs(10));
	}

}
