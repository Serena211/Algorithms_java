package Class06_Graph2;

import java.util.ArrayList;
import java.util.Arrays;
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

public class Cents99_arraylist {
	public static List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> rsl = new ArrayList<List<Integer>>();
		
		//use ArrayList to store current solution
		List<Integer> curSolution = new ArrayList<Integer>();
		helper(target, coins, 0, curSolution, rsl);
		return rsl;
	}
	
	private static void helper(int target, int[] coins, int index,
			List<Integer> curSolution, List<List<Integer>> rsl) {
		// base case: have traversed all denominations
		if (index == coins.length - 1) {
			if(target % coins[index] == 0) {
			curSolution.add(target/coins[index]);
			rsl.add(new ArrayList<Integer>(curSolution));
			curSolution.remove(curSolution.size() - 1);
			}
			return;
			
		} 
		int branch = target / coins[index];
		for (int i = 0; i <= branch; i++) {
			int moneyLeft = target - coins[index] * i;
			curSolution.add(i);
			helper(moneyLeft, coins, index + 1, curSolution, rsl);
			curSolution.remove(curSolution.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] coins = new int[]{5,2,1};
		List<List<Integer>> rsl = combinations(30, coins);
		System.out.println(rsl.toString());
	}

}
