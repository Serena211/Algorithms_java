package Class99_Mix;

/*
 * Given an array of positive integers representing a stock’s price on each day. 
 * On each day you can only make one operation: either buy or sell one unit of 
 * stock, you can make as many transactions you want, but at any time you can only 
 * hold at most one unit of stock. Determine the maximum profit you can make.
 * 
 * Assumptions
 * The give array is not null and is length of at least 2
 * 
 * Examples
 * {2, 3, 2, 1, 4, 5}, the maximum profit you can make is (3 - 2) + (5 - 1) = 5
 */
public class BuyStock2 {
	// This problem is a kind of find ascending subarray problem
	public int maxProfit(int[] array) {
//		int maxProfit = array[1] - array[0] < 0? 0 : array[1] - array[0];
//		int min = Math.min(array[0], array[1]);
		int maxProfit = 0;
		int min = array[0];
//		boolean sign = false;
		for (int i = 1; i < array.length; i++) {
			while (i < array.length && array[i] >= array[i - 1]) {
				i++;
			}
			maxProfit = maxProfit + array[i - 1] - min;

			if (i < array.length) {
				min = array[i];
			} 

		}
		return maxProfit;
	}

	public static void main(String[] args) {
		BuyStock2 sol = new BuyStock2();
		System.out.println(sol.maxProfit(new int[]{2,1,3,6,2,4}));	// 7
		System.out.println(sol.maxProfit(new int[]{2,1}));	// 0
		System.out.println(sol.maxProfit(new int[]{2,1,3}));	// 2
		System.out.println(sol.maxProfit(new int[]{0,1,4,1,5}));	// 8

	}

}
