package Class10_Recursion;

/*
 * Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, 
 * return if the string matches the abbreviation.
 * 
 * Assumptions:
 * The original string only contains alphabetic characters.
 * Both input and pattern are not null.
 * 
 * Examples:
 * pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
 */

public class StringAbbreviationMatching {
	public boolean match(String input, String pattern) {
		if (input.length() == 0 && pattern.length() == 0) {
			return true;
		} else if (input.length() == 0 || pattern.length() == 0) {
			return false;
		}
		if (isDigit(pattern.charAt(0))) {
			int i = 0;
			int num = 0;
			while (i < pattern.length() && isDigit(pattern.charAt(i))) {
				num = num * 10 + (pattern.charAt(i) - '0');
				i++;
			}
			if (num > input.length()) {
				return false;
			} else {
				return match(input.substring(num), pattern.substring(i));
			}
		} else {
			if (pattern.charAt(0) == input.charAt(0)) {
				return match(input.substring(1), pattern.substring(1));
			}
			return false;
		}
	}


	private boolean isDigit(char c) {
		return c >= '0' && c <= '9';
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
