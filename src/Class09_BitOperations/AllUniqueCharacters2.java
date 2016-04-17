package Class09_BitOperations;

/*
 * Determine if the characters of a given string are all unique.
 * 
 * Assumptions
 * We are using ASCII charset, the value of valid characters are from 0 to 255
 * The given string is not null
 * 
 * Examples
 * all the characters in "abA+\8" are unique
 * "abA+\a88" contains duplicate characters
 */

public class AllUniqueCharacters2 {
	public boolean allUnique(String word) {
		if (word.length() <=1) {
			return true;
		}
		
		int[] charSet = new int[8];
		for (int i = 0; i < word.length(); i++) {
			int row = word.charAt(i) / 32;
			int col = 1 << (word.charAt(i) % 32);
			if ((charSet[row] & col) == 0) {
				charSet[row] |= col;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllUniqueCharacters2 sol = new AllUniqueCharacters2();
		System.out.println(sol.allUnique("dkjflawei"));
	}

}
