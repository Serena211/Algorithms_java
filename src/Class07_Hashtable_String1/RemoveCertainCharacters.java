package Class07_Hashtable_String1;

import java.util.HashSet;

/*
 * Remove given characters in input string, the relative order of other 
 * characters should be remained. Return the new string after deletion.
 * 
 * Assumptions
 * The given input string is not null.
 * The characters to be removed is given by another string, it is guranteed to be not null.
 * 
 * Examples
 * input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
 */

public class RemoveCertainCharacters {
	public String remove(String input, String t) {
		if (input == null || t == null || input.length() == 0) {
			return new String("");
		}
		if (t.length() == 0) {
			return input;
		}
		char[] in = input.toCharArray();
		HashSet<Character> target = new HashSet<Character>();
		for (int i = 0; i < t.length(); i++) {
				target.add(t.charAt(i));
		}
		int slow = 0;
		int fast = 0;
		while (fast < in.length) {
			if (!target.contains(in[fast])) {
				in[slow++] = in[fast++];
			} else {
				fast++;
			}
		}
		return new String(in, 0, slow);
	}

	public static void main(String[] args) {
		RemoveCertainCharacters sol = new RemoveCertainCharacters();
		System.out.println(sol.remove("student", "student"));
	}

}
