package Class99_Mix;

/*
 * Determine if the characters of a given string are all unique.
 * 
 * Assumptions
 * The only set of possible characters used in the string are 'a' - 'z', the 26 lower case letters.
 * The given string is not null.
 * 
 * Examples
 * the characters used in "abcd" are unique
 * the characters used in "aba" are not unique
 */
public class AllUniqueCharacters1 {
	public boolean allUnique(String word) {
		// if input string has no char, return true
		if (word.length() <= 1) {
			return true;
		}
		if (word.length() >26) {
			return false;
		}
		int a  = 0;
		char[] w = word.toCharArray();
		for(char c : w) {
			int temp = c - 'a';
			if ((a & (1 << temp) ) == 0) {
				a |= (1 << temp);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllUniqueCharacters1 sol = new AllUniqueCharacters1();
		System.out.println(sol.allUnique("zyxyaqwcns"));
	}

}
