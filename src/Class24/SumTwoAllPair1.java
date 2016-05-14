package Class24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Find all pairs of elements in a given array that sum to the given target number. 
 * Return all the pairs of indices.
 * 
 * Assumptions
 * The given array is not null and has length of at least 2.
 * 
 * Examples
 * A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]
 * A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]
 */
public class SumTwoAllPair1 {
	public List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> rsl = new ArrayList<List<Integer>>();
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			List<Integer> cur = map.get(target - array[i]);
			if (cur != null) {
				for (Integer n : cur) {
					rsl.add(Arrays.asList(i,n));
				}
			}
			if (!map.containsKey(array[i])) {
				map.put(array[i], new ArrayList<Integer>());
			}
			map.get(array[i]).add(i);
		}
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
