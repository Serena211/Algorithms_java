package Class99_Mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/*
 * Find all numbers that appear in both of the two unsorted arrays.
 * 
 * Assumptions
 * Both arrays are not null.
 * There are no duplicate numbers in each of the two arrays respectively.
 * 
 * Examples
 * A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
 * A = {}, B = {3, 1, 4}, return []
 */
public class CommonNumbersOfTwoArrays1 {
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (a.size() == 0 || b.size() == 0) {
			return rsl;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		if (a.size() < b.size()) {
			for (Integer i : a) {
				set.add(i);
			}
			findCommon(rsl, set, b);
		} else {
			for (Integer i : b) {
				set.add(i);
			}
			findCommon(rsl, set, a);
		}
		Collections.sort(rsl);
		return rsl;
	}

	private void findCommon(List<Integer> rsl, HashSet<Integer> set,
			 List<Integer> b) {
		for (Integer i : b) {
			if (set.contains(i)) {
				rsl.add(i);
			}
		}
	}

	public static void main(String[] args) {
		CommonNumbersOfTwoArrays1 sol = new CommonNumbersOfTwoArrays1();
		System.out.println(sol.common(Arrays.asList(5,1,3,2,4), Arrays.asList(4,2,3)));
//		java.util.Arrays.asList(5,1,3,2,4),java.util.Arrays.asList(4,2,3)
	}

}
