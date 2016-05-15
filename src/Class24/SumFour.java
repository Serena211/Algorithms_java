package Class24;

import java.util.HashMap;

/*
 * Determine if there exists a set of four elements in a given array that sum to 
 * the given target number.
 * 
 * Assumptions
 * The given array is not null and has length of at least 4
 * 
 * Examples
 * A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 8)
 * A = {1, 2, 2, 3, 4}, target = 12, return false
 */
public class SumFour {
	public boolean exist(int[] array, int target) {
		HashMap<Integer, Integer[]> map = new HashMap<>();
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int sumTwo = array[i] + array[j];
				Integer[] cur = map.get(target - sumTwo);
				if (cur != null && cur[0] != i && cur[0] != j && cur[1] != i && cur[1] != j) {
					return true;
				} else {
					System.out.println(sumTwo);
					map.put(sumTwo, new Integer[]{i,j});
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SumFour sol = new SumFour();
		System.out.println(sol.exist(new int[]{3,1,6,3,6,16,40},23));
	}

}
