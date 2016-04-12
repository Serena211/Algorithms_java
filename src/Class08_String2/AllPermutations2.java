package Class08_String2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/*
 * Given a string with possible duplicate characters, return a list with 
 * all permutations of the characters.
 * 
 * Examples
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 * Set = "aba", all permutations are ["aab", "aba", "baa"]
 * Set = "", all permutations are [""]
 * Set = null, all permutations are []
 */

public class AllPermutations2 {
	public List<String> permutations(String set) {
		List<String> rsl = new ArrayList<String>();
		if (set == null) {
			return rsl;
		}
		char[] input = set.toCharArray();
		helper(input, rsl, 0);
		return rsl;
	}

	private void helper(char[] input, List<String> rsl, int index) {
		if (index == input.length) {
			rsl.add(new String(input));
			return;
		}
		HashSet<Character> visited = new HashSet<Character>();		
		for (int j = index; j < input.length; j++) {
			if (!visited.contains(input[j])) {
				visited.add(input[j]);
				swap(input, j, index);
				helper(input, rsl, index + 1);
				swap(input, j, index);
			}
		}
	}

	private void swap(char[] arr, int i, int j) {
		// TODO Auto-generated method stub
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
