package Class09_BitOperations;
/*
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the 
 * bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 */

public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int xor = n;
        for(int i = m; i < n; i++) {
            xor &= i;
        }
        return xor;
    }
	public static void main(String[] args) {
		BitwiseANDofNumbersRange sol = new BitwiseANDofNumbersRange();
		System.out.println(sol.rangeBitwiseAnd(0, 2147483647));
	}

}
