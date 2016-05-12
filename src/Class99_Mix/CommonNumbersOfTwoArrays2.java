package Class99_Mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
 * Find all numbers that appear in both of two unsorted arrays.
 * 
 * Assumptions
 * Both of the two arrays are not null.
 * In any of the two arrays, there could be duplicate numbers.
 * 
 * Examples
 * A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)
 */
public class CommonNumbersOfTwoArrays2 {
	public List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (a.size() == 0 || b.size() == 0) {
			return rsl;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (a.size() < b.size()) {
			for (Integer i : a) {
				Integer count = map.get(i); 
				if (count == null) {
					map.put(i, 1);
				} else {
					map.put(i, count + 1);
				}
			}
			findCommon(rsl, map, b);
		} else {
			for (Integer i : b) {
				Integer count = map.get(i); 
				if (count == null) {
					map.put(i, 1);
				} else {
					map.put(i, count + 1);
				}			}
			findCommon(rsl, map, a);
		}
		Collections.sort(rsl);
		return rsl;
	}

	private void findCommon(List<Integer> rsl, HashMap<Integer, Integer> map,
			 List<Integer> b) {
		for (Integer i : b) {
			Integer count = map.get(i);
			if (count != null && count != 0) {
				rsl.add(i);
				map.put(i, count - 1);
			}
		}
	}

	public static void main(String[] args) {
		CommonNumbersOfTwoArrays2 sol = new CommonNumbersOfTwoArrays2();
		System.out.println(sol.common(Arrays.asList(5,1,3,2,2,2,4), Arrays.asList(4,2,2,3)));
	}

}
