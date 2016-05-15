package Class24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * Find all pairs of elements in a given array that sum to the pair the given 
 * target number. Return all the distinct pairs of values.
 * 
 * Assumptions
 * The given array is not null and has length of at least 2
 * The order of the values in the pair does not matter
 * 
 * Examples
 * A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
 */
public class SumTwoAllPair2 {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> rsl = new ArrayList<List<Integer>>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (Integer n : array) {
			// Integer temp = map.get(target - n);
			Integer count = map.get(n);
			// handle when to add current pair to result set.
			if (2 * n == target && count != null && count == 1) {
				rsl.add(Arrays.asList(n,n));
			} else if (map.containsKey(target - n) && count == null) {
				rsl.add(Arrays.asList(n, target - n));
			} 
			// how to put current integer to map
			if (count == null) {
				map.put(n, 1);
			} else {
				map.put(n, count + 1);
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		SumTwoAllPair2 sol = new SumTwoAllPair2();
		System.out.println(sol
				.allPairs(new int[] { -1,1}, 0));
	}

}
