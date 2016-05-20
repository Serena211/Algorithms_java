package Class99_Mix;

/*
 * Given an array of positive integers representing a stock’s price on each day. 
 * On each day you can only make one operation: either buy or sell one unit of 
 * stock, at any time you can only hold at most one unit of stock, and you can 
 * make at most 2 transactions in total. Determine the maximum profit you can make.
 * 
 * Assumptions
 * The give array is not null and is length of at least 2
 * 
 * Examples
 * {2, 3, 2, 1, 4, 5, 2, 11}, the maximum profit you can make is (5 - 1) + (11 - 2) = 13
 */
public class BuyStock3 {
	public int maxProfit(int[] array) {
		int firstProfit = 0;
		int secondProfit = 0;
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			int temp = Integer.MIN_VALUE;
			while (i < array.length && array[i] > min) {
				temp = Math.max(temp, array[i] - min);
				i++;
			}

			if (temp > firstProfit) {
				secondProfit = firstProfit;
				firstProfit = temp;
			} else {
				secondProfit = temp > secondProfit ? temp : secondProfit;
			}
			if (i < array.length) {
				min = Math.min(array[i], min);
			}

		}
		return firstProfit + secondProfit;
	}

	public static void main(String[] args) {
		BuyStock3 sol = new BuyStock3();
		System.out.println(sol.maxProfit(new int[]{3,4,1,2,6,2,3,5,1,7,3,8}));
	}

}
