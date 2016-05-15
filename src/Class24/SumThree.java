package Class24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Determine if there exists three elements in a given array that sum to the 
 * given target number. Return all the triple of values that sums to target.
 * 
 * Assumptions
 * The given array is not null and has length of at least 3
 * No duplicate triples should be returned, order of the values in the tuple does not matter
 * 
 * Examples
 * A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
 */
public class SumThree {
	public List<List<Integer>> allTriples(int[] array, int target) {
		List<List<Integer>> rsl = new ArrayList<List<Integer>>();
		Arrays.sort(array);
		// three pointers:
		// no duplicate triples ==> pointers don't get same num
		for (int i = 0; i < array.length; i++) {
			while (i > 0 && i < array.length && array[i] == array[i - 1]) {
				i++;
			}
			int j = i + 1;
			int k = array.length - 1;
			while (j < k) {
				int sum3 = array[i] + array[j] + array[k];
				if (sum3 == target) {
					rsl.add(Arrays.asList(array[i], array[j], array[k]));
					j++;
					while (j < k && array[j] == array[j - 1]) {
						j++;
					}
				} else {
					if (sum3 > target) {
						k--;
					} else {
						j++;
					}
				}
			}

		}
		return rsl;
	}

	public static void main(String[] args) {
		SumThree sol = new SumThree();
		System.out.println(sol.allTriples(new int[] { 1, 1,1 ,6}, 8));
	}

}
