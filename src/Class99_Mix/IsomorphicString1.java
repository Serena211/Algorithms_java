package Class99_Mix;

import java.util.HashMap;

/*
 * Two Strings are called isomorphic if the letters in one String can be remapped to 
 * get the second String. Remapping a letter means replacing all occurrences of it 
 * with another letter. The ordering of the letters remains unchanged. The mapping is 
 * two way and no two letters may map to the same letter, but a letter may map to 
 * itself. Determine if two given String are isomorphic.
 * 
 * Assumptions:
 * The two given Strings are not null.
 * 
 * Examples:
 * "abca" and "xyzx" are isomorphic since the mapping is 'a' <-> 'x', 'b' <-> 'y', 
 * 'c' <-> 'z'.
 * 
 * "abba" and "cccc" are not isomorphic.
 */
public class IsomorphicString1 {
	// method 1: use array[0 -255]
	// to be continue;
	
	// method 2: use hashmap
	public boolean isomorphic(String s, String t) {
		HashMap<Character,Character> mapS = new HashMap<Character, Character>();
		HashMap<Character,Character> mapT = new HashMap<Character, Character>();
		if (s.length() != t.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			Character curS = mapS.get(s.charAt(i));
			if (curS != null && curS != t.charAt(i)) {
				return false;
			}
			mapS.put(s.charAt(i), t.charAt(i));
			Character curT = mapT.get(t.charAt(i));
			if (curT != null && curT != s.charAt(i)) {
				return false;
			}
			mapT.put(t.charAt(i), s.charAt(i));
			
		}
		return true;
//		for (int i = 0; i < t.length(); i++) {
//			char temp = t.charAt(i);
//			Character cur = mapT.get(temp);
//			if (cur == null) {
//				System.out.println(s.charAt(i) + ", " + t.charAt(i));
//				mapT.put(t.charAt(i), s.charAt(i));
//			} else {
//				if (cur != s.charAt(i)) {
//					return false;
//				}
//			}
//		}
//		return true;
    }
	public static void main(String[] args) {
		IsomorphicString1 sol = new IsomorphicString1();
		System.out.println(sol.isomorphic("aabc", "bbaa"));
	}

}
