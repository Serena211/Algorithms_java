package Class12_DP2;

import java.util.HashSet;

/*
 * Given a word and a dictionary, determine if it can be composed by concatenating 
 * words from the given dictionary.
 * 
 * Assumptions
 * 1. The given word is not null and is not empty
 * 2. The given dictionary is not null and is not empty and all the words in the dictionary 
 * are not null or empty
 * 
 * Examples
 * Dictionary: {“bob”, “cat”, “rob”}
 * Word: “robob” return false
 * Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
 */
public class DictionaryWord1 {
	public boolean canBreak(String input, String[] dict) {
		HashSet<String> dictSet = new HashSet<String>();
		for (String i : dict) {
			dictSet.add(i);
		}
		// Induction rule: M[i] represents substring 0-th to i-th can be broke (include i);
		boolean[] M = new boolean[input.length() + 1];
		for (int i = 1; i <= input.length(); i++) {
			// i represents the length of substring
			for (int j = 0; j < i; j++) {
//				String cur = input.substring(j, i);
//				System.out.println(cur);
				if (j == 0 && dictSet.contains(input.substring(j, i))) {
					M[i] = true;
//					System.out.println(i + " true");
					break;
				} else if (M[j] && dictSet.contains(input.substring(j, i))) {
					M[i] = true;
//					System.out.println(input.substring(0, j) + " + " + "cur");
					break;
				}
			}
		}
		return M[input.length()];
	}

	public static void main(String[] args) {
		DictionaryWord1 sol = new DictionaryWord1();
		String[] dict = new String[]{"asd","wen"};
		System.out.println(sol.canBreak("asdowen", dict));
	}

}
