package Class99_Mix;

import java.util.HashMap;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] string1 = s.toCharArray();
        char[] string2 = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : string1) {
            Integer count = map.get(c);
            if (count == null) {
                map.put(c,1);
            } else {
                map.put(c, count + 1);
            }
        }
        for (char c : string2) {
            Integer count = map.get(c);
            if (count == null || count == 0) {
                return false;
            } else {
                map.put(c, count - 1);
            }
        }
        return true;
    }
	public static void main(String[] args) {
		ValidAnagram sol = new ValidAnagram();
		System.out.println(sol.isAnagram("a", "a"));
	}

}
