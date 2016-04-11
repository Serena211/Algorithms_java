package Class07_Hashtable_String1;

/*
 * Determine if a small string is a substring of another large string.
 * Return the index of the first occurrence of the small string in the large string.
 * Return -1 if the small string is not a substring of the large string.
 * 
 * Assumptions
 * Both large and small are not null
 * If small is empty string, return 0
 * 
 * Examples
 * “ab” is a substring of “bcabc”, return 2
 * “bcd” is not a substring of “bcabc”, return -1
 * "" is substring of "abc", return 0
 */

public class DetermineIfOneStringIsAnotherSubstring {
	public int strstr(String large, String small) {
		if (large == null || small == null || large.length() < small.length()) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
// no need to change to char[], because no operate on strings
//		char[] l = large.toCharArray();
//		char[] s = small.toCharArray();
		for (int i = 0; i <= large.length() - small.length(); i++) {
			int j = 0;
			while (j < small.length()) {
				if (large.charAt(i + j) != small.charAt(j)) {
					break;
				} else {
					j++;
				}
			}
			if (j == small.length()) {
				return i;
			}
	
		}
		return -1;
	}

	public static void main(String[] args) {
		DetermineIfOneStringIsAnotherSubstring sol = new DetermineIfOneStringIsAnotherSubstring();
		System.out.println(sol.strstr("", "bn"));

	}

}
