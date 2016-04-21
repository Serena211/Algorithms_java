package Class11_DP1;

/*
 * Given a rope with positive integer-length n, how to cut the rope into m integer-length 
 * parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of 
 * p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one 
 * cut must be made). Return the max product you can have.
 * 
 * Assumptions
 * n >= 2
 * 
 * Examples
 * n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of 
 * each is 3).
 */

public class MaxProductOfCuttingRope {
	public int maxProduct(int length) {
		// Write your solution here.
		if (length == 2) {
			return 1;
		}
		int[] product = new int[length + 1];
		product[1] = 0;
		product[2] = 1;
		for (int i = 3; i < product.length; i++) {
			for (int j = 1; j <= i/2; j++) {
				product[i] = Math.max(product[i], j * Math.max(i - j, product[i - j]));
			}
		}
		return product[length];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProductOfCuttingRope sol = new MaxProductOfCuttingRope();
		System.out.println(sol.maxProduct(9));
	}

}
