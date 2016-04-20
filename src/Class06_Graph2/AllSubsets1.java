package Class06_Graph2;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of characters represented by a String, 
 * return a list containing all subsets of the characters.
 * 
 * Assumptions
 * There are no duplicate characters in the original set.
 * 
 * Examples
 * Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 * 
 * Time Complexity: 
 * it has string.length() level, the number of nodes:
 * 2^1 + 2^2 + ... + 2^(string.length() - 1)
 * each node will be traversed 1 time.
 * So, time complexity should be about O(2^(string.length())) 
 * */
public class AllSubsets1 {
	public static List<String> subSets(String set) {
		List<String> result = new ArrayList<String>();
		// check corner case
		if (set == null) {
			return result;
		}
		// change string to stringbuild, easy to append or remove elements of string
		StringBuilder origin = new StringBuilder(set);
		StringBuilder temp = new StringBuilder();
		// recursive find all sub sets
		helper(origin, temp, result, 0);
		return result;
	}
	private static void helper(StringBuilder origin, StringBuilder temp,
			List<String> result, int index) {
		// base case: add solution to result list
		if (index == origin.length()) {
			result.add(new String(temp));
			return;
		}
		// recursion rule:
		// 1. add string.charAt(index) to subset
		temp.append(origin.charAt(index));
		helper(origin, temp, result, index + 1);
		temp.deleteCharAt(temp.length() - 1);	
		// 2. add nothing
		helper(origin, temp, result, index + 1);	
	}
	public static void main(String[] args) {
		String t = "asd";
		List<String> rsl = subSets(t);
		for(String s : rsl) {
			System.out.println(s);
		}
	}

}
