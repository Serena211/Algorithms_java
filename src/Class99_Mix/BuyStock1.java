package Class99_Mix;

/*
 * Given an array of positive integers representing a stock’s price on each day. 
 * On each day you can only make one operation: either buy or sell one unit of 
 * stock and you can make at most 1 transaction. Determine the maximum profit 
 * you can make.
 * 
 * Assumptions
 * The given array is not null and is length of at least 2.
 * 
 * Examples
 * {2, 3, 2, 1, 4, 5}, the maximum profit you can make is 5 - 1 = 4
 */
public class BuyStock1 {
	// public int maxProfit(int[] array) {
	// int[] M = new int[array.length];
	// //
	// M[0] = 0;
	// int buy = array[0];
	// int sell = array[1];
	// M[1] = array[1] - array[0] < 0? 0 : buy - sell;
	// // induction rule: M[i] is 0 to i-th index of array, the maximum profit;
	// for (int i = 2; i < array.length; i++) {
	// if (array[i] > sell) {
	// sell = array[i];
	// } else {
	// if (array[i] < buy) {
	// buy = array[i];
	// sell = buy;
	// }
	// }
	// M[i] = Math.max(M[i - 1], sell - buy);
	// }
	// return M[array.length - 1];
	// }
	public int maxProfit(int[] array) {
		int maxProfit = 0;
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			min = Math.min(min, array[i]);
			maxProfit = Math.max(maxProfit, array[i] - min);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		BuyStock1 sol = new BuyStock1();
		System.out.println(sol.maxProfit(new int[] {2, 3, 2, 1, 4, 2, 5}));
	}

}
