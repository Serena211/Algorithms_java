package Class08_String2;

import java.util.HashMap;

/*
 * Given a string, find the longest substring without any repeating characters 
 * and return the length of it. The input string is guaranteed to be not null.
 * 
 * For example, the longest substring without repeating letters for "bcdfbd" is 
 * "bcdf", we should return 4 in this case.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int longest(String input) {
		int longest = 0;
		HashMap<Character, Integer> visited = new HashMap<Character, Integer>();
		int start = 0;
		visited.put(input.charAt(start),0);
		int end = 1;
		helper(longest, visited,0,1);
		return longest;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
