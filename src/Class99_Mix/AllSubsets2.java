package Class99_Mix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Given a set of characters represented by a String, return a list containing all 
 * subsets of the characters.
 * 
 * Assumptions
 * There could be duplicate characters in the original set.
 * 
 * Examples
 * Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
 * Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
 * Set = "", all the subsets are [""]
 * Set = null, all the subsets are []
 */

public class AllSubsets2 {
	public List<String> subSets(String set) {
		List<String> rsl = new ArrayList<String>();
		if (set == null) {
			return rsl;
		}
//		if (set.length() == 0) {
//			rsl.add("");
//			return rsl;
//		}
		HashSet<String> subset = new HashSet<String>();
		StringBuilder sb =  new StringBuilder();
		rsl.add("");
		char[] input = set.toCharArray();
		Arrays.sort(input);
		helper(rsl,subset,input, 0,sb);
		return rsl;
	}

	private void helper(List<String> rsl, HashSet<String> subset, char[] input,int index,
			StringBuilder sb) {
		// TODO Auto-generated method stub
		if (index == input.length) {
			return;
		}
		sb = sb.append(input[index]);
//		if (subset.add(new String(sb))) {
		if (!subset.contains(sb)) {		//delete this
			subset.add(new String(sb));	// and delete this
			rsl.add(new String(sb));
			helper(rsl, subset, input, index + 1, sb);
		}
		sb.deleteCharAt(sb.length() - 1);
		
		helper(rsl, subset, input, index + 1, sb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllSubsets2 sol = new AllSubsets2();
		System.out.println(sol.subSets("abbc"));
	}

}
