package Class02_Recursion;

import java.util.Arrays;

/*
 * Given a integer dictionary A of unknown size, where the numbers 
 * in the dictionary are sorted in ascending order, determine if a 
 * given target integer T is in the dictionary. Return the index of 
 * T in A, return -1 if T is not in A.
 * 
 * Assumptions
 * dictionary A is not null
 * dictionary.get(i) will return null if index i is out of bounds
 * 
 * Examples
 * A = {1, 2, 5, 9, ......}, T = 5, return 2
 * A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
 * */

// Solution:
// Step1: keep jumping out until array[2^k] >= target || array[2^k] == null
// Step2: left = 2^(k - 1); right = 2^k; do binary search.
public class SearchInUnknownSizedSortedArray {
	public int search(Dictionary dict, int target) {
		if(dict == null || dict.get(0) == null) {
			return -1;
		}
		if (dict.get(0) == target) {
			return 0;
		}
		int index = 1;		
		while(dict.get(index) != null && dict.get(index) < target) {
			index = index * 2;
		}
		return BST(dict, target, index/2,index);
		}
	private int BST(Dictionary dict, int target, int l, int r) {
		
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (dict.get(mid) == null) {
				r = mid - 1;
			} else if (dict.get(mid) == target) {
				return mid;
			} else if(dict.get(mid) < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		SearchInUnknownSizedSortedArray sol = new SearchInUnknownSizedSortedArray();
		Dictionary dict = new DictImpl(null);
		System.out.println(sol.search(dict, 4));
	}

}
interface Dictionary {
	public Integer get(int index);
}
class DictImpl implements Dictionary {
	private int[] array;
	public DictImpl(int[] input) {
		// TODO Auto-generated constructor stub
		array = input;
	}
	@Override
	public Integer get(int index) {
		// TODO Auto-generated method stub
		if(array == null || index >= array.length) {
			return null;
		}
		return array[index];
	}
	@Override
	public String toString() {
		if(array == null) {
			return String.valueOf(null);
		}
		if(array.length < 10) {
			return Arrays.toString(array);
		}
		// truncate array
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < 5; i++) {
			sb.append(array[i]).append(", ");
		}
		sb.append("..........");
		for (int j = array.length - 5; j < array.length; j++) {
			sb.append(array[j]).append(", ");
		}
		sb.replace(sb.length()-2, sb.length()-1, "]");
		return sb.toString();
	}
	
}