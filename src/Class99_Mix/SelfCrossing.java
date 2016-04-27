package Class99_Mix;
/*
 * You are given an array x of n positive numbers. You start at point (0,0) and 
 * moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to 
 * the south, x[3] metres to the east and so on. In other words, after each move 
 * your direction changes counter-clockwise.
 * 
 * Write a one-pass algorithm with O(1) extra space to determine, if your path 
 * crosses itself, or not.
 */

/*
 * Solution:
 * 1. ┌───┐
 * 	  │   │
 * 	  └───┼──>
 * 		  │
 * 2. ┌───┐
 * 	  │   │
 *    │   ^
 * 	  │   │
 * 	  └───┘
 * 3. ┌───┐
 * 	  │   │
 *    │   <─────┐
 * 	  │   		│
 * 	  └─────────┘
		  
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length <4) {
        	return false;
        }
        int n = x.length;
//        for (int i = 3; i < n; i++) which one better? small to large Or large to small?
        for (int i = n - 1; i >= 3; i--) {
			if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
				return true;
			}
			if (i >= 4 && x[i - 2] >= x[i - 4] && x[i] >= x[i - 2] - x[i - 4] && x[i - 3] == x[i - 1]) {
				return true;
			}
			if (i >= 5 && x[i - 2] >= x[i - 4] && x[i - 2] >= x[i] && x[i - 2] - x[i - 4] <= x[i]  && x[i - 3] - x[i - 5] <= x[i - 1] && x[i - 3] >= x[i - 5] && x[i - 3] >= x[i - 1]) {
				System.out.println(i + " is i");
				return true;
			}
		}
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelfCrossing sol = new SelfCrossing();
		int[] x = new int[]{1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1};
		System.out.println(sol.isSelfCrossing(x));
	}

}
