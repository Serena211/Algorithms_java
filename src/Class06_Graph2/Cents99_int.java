package Class06_Graph2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cents99_int {
	public static List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> rsl = new ArrayList<List<Integer>>();
		
		// use Integer[] to store current solution
		Integer[] curSolution = new Integer[coins.length];
		helper(target, coins, 0, curSolution, rsl);
		return rsl;
	}
	
	private static void helper(int target, int[] coins, int index,
			Integer[] curSolution, List<List<Integer>> rsl) {
		// base case: have traversed all denominations
		if (index == coins.length - 1) {
			if(target % coins[index] == 0) {
				curSolution[index] = target/coins[index];
				List<Integer> a = Arrays.asList(curSolution);
				rsl.add(new ArrayList<Integer>(a));
			}
			return;
			
		} 
		int branch = target / coins[index];
		for (int i = 0; i <= branch; i++) {
			int moneyLeft = target - coins[index] * i;
			curSolution[index] = i;
			helper(moneyLeft, coins, index + 1, curSolution, rsl);
		}
		
	}
}
