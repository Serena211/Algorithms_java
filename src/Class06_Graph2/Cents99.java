package Class06_Graph2;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a number of different denominations of coins 
 * (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all 
 * the possible ways to pay a target number of cents.
 * 
 * Arguments
 * coins - an array of positive integers representing the 
 * 		   different denominations of coins, there are no 
 * 		   duplicate numbers and the numbers are sorted by 
 * 		   descending order, eg. {25, 10, 5, 2, 1}
 * target - a positive integer representing the target number 
 * 			of cents, eg. 99
 * 
 * Assumptions
 * coins is not null and is not empty, all the numbers in coins are positive
 * target >= 0
 * You have infinite number of coins for each of the denominations, 
 * you can pick any number of the coins.
 * 
 * Return
 * a list of ways of combinations of coins to sum up to be target.
 * each way of combinations is represented by list of integer, 
 * the number at each index means the number of coins used for 
 * the denomination at corresponding index.
 * */

public class Cents99 {
	public List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> rsl = new ArrayList<List<Integer>>();
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
