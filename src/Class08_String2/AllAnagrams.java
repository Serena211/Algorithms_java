package Class08_String2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Find all occurrence of anagrams of a given string s in a given string l. 
 * Return the list of starting indices.
 * 
 * Assumptions
 * s is not null or empty.
 * l is not null.
 * 
 * Examples
 * l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 
 * starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 */
public class AllAnagrams {
	List<Integer> allAnagrams(String s, String l) {
		// corner case:
		List<Integer> rsl = new ArrayList<Integer>();
		if (l.length() == 0 || s.length() > l.length()) {
			return rsl;
		}
		// add s to hashmap
		HashMap<Character,Integer> small = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Integer count = small.get(s.charAt(i));
			if (count == null) {
				small.put(s.charAt(i), 1);
			} else {
				small.put(s.charAt(i), count + 1);
			}
		}
		// now handle l string
		int charMatch = 0;
		for (int i = 0; i < l.length(); i++) {
			char temp = l.charAt(i);
			Integer count = small.get(temp);
			if (count != null) {
				small.put(temp, count - 1);
				if (count - 1 == 0) {
					charMatch++;
				}
			}
			if (i >= s.length()) {
				temp = l.charAt(i - s.length());
				count = small.get(temp);
				if (count != null) {
					small.put(temp, count+1);
					if (count == 0) {
						charMatch--;
					}
				}
			}
			if (charMatch == small.size()) {
				rsl.add(i - s.length() + 1);
			}
		}
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
