package Class99_Mix;
/*
 * Given a positive integer n, break it into the sum of at least two positive integers 
 * and maximize the product of those integers. Return the maximum product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * 
 * Note: you may assume that n is not less than 2.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
    	int[] product = new int[n + 1];
    	product[0] = 0;
    	product[1] = 0;
    	product[2] = 1;
    	for (int i = 3; i <= n; i++) {
    		int result = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				result = Math.max(result, j * Math.max(i - j, product[i - j]));
			}
			product[i] = result;
		}
    		
    	return product[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerBreak sol = new IntegerBreak();
		System.out.println(sol.integerBreak(10));
	}

}
