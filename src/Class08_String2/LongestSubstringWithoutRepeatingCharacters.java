package Class08_String2;

import java.util.HashSet;

/*
 * Given a string, find the longest substring without any repeating characters 
 * and return the length of it. The input string is guaranteed to be not null.
 * 
 * For example, the longest substring without repeating letters for "bcdfbd" is 
 * "bcdf", we should return 4 in this case.
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int longest(String input) {
		// corner case:
		if (input.length() <= 1) {
			return input.length();
		}
		int longest = 0;
		int slow = 0;
		int fast = 0;
		HashSet<Character> visited = new HashSet<Character>();
		while (fast < input.length()) {
			char temp = input.charAt(fast);
			if (visited.contains(temp)) {
				visited.remove(input.charAt(slow++));
			} else {
				visited.add(temp);
				fast++;
				longest = Math.max(longest, fast - slow);
			}
		}
		return longest;
	}
	
	public String longestString(String input) {
		if (input.length() <= 1) {
			return input;
		}
		HashSet<Character> visited = new HashSet<Character>();
		int longest = 0;
		int start = 0;
		int end = 0;
		int fast = 0;
		int slow = 0;
		while (fast < input.length()) {
			char temp = input.charAt(fast);
			if (visited.contains(temp)) {
				visited.remove(input.charAt(slow++));
			} else {
				visited.add(temp);
				fast++;
				if (longest < fast - slow) {
					longest = fast - slow;
					start = slow;
					end = fast;
				}
			}
		}
		return input.substring(start, end); // [start,end)
	}


	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(sol.longestString("a"));
	}

}
