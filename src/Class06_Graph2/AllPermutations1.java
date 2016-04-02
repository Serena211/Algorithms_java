package Class06_Graph2;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string with no duplicate characters, 
 * return a list with all permutations of the characters.
 * 
 * Examples
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 * */

public class AllPermutations1 {
	public List<String> permutations(String set) {
		List<String> rsl = new ArrayList<String>();
		if (set == null) {
			return rsl;
		}
		// convert string to char array
		char[] temp = set.toCharArray();
		helper(temp, 0, rsl);
		return rsl;
	}
	private void helper(char[] temp, int index, List<String> rsl) {
		//base case:
		if (index == temp.length) {
			rsl.add(new String(temp));
		}
		// recursion rule:
		// index is the current layer that we are trying
		for (int i = index; i < temp.length; i++) {
			swap(i,index,temp);
			//put each letter in the index-th position of input char[]
			helper(temp,index + 1, rsl);
			swap(i,index,temp);
		}
	}
	// swap two chars' position in a array
	private void swap(int x, int y, char[] arr) {
		char temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
