package Class06_Graph2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cents99_collections {
	public static List<List<Integer>> combinations(int target, int[] coins) {
		// int index = 0 record which type of coins we get.
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		//!!!!!!!!!!!!Collections!!!!!!!!!!!!
		List<Integer> sol = new ArrayList<Integer>(Collections.nCopies(coins.length, 0));
		helper(target, coins, 0, sol, result);
		return result;
	}

	private static void helper(int target, int[] coins, int index, List<Integer> sol,
			List<List<Integer>> result) {
	    //assert index <= coins.length -1;
		if (index == coins.length - 1) {
			if (target % coins[index] == 0) {
				sol.set(index, target / coins[index]);
				result.add(new ArrayList<Integer>(sol)); //new ArrayList(sol).
			}
			return;
		}
		int branch = target / coins[index];
		for (int i = 0; i <= branch; i++) {
			sol.set(index, i);
			int money_left = target - i * coins[index];		//keep target
			helper(money_left, coins, index + 1, sol, result);
		}
	}
}
