package Class99_Mix;

/*
 * Given a string with only character 'a' and 'b', replace some of the characters 
 * such that the string becomes in the forms of all the 'b's are on the right side 
 * of all the 'a's.
 * 
 * Determine what is the minimum number of replacements needed.
 * 
 * Assumptions:
 * The given string is not null.
 * 
 * Examples:
 * "abaab", the minimum number of replacements needed is 1 (replace the first 'b' with 
 * 'a' so that the string becomes "aaaab").
 */
public class ReplacementsOfAAndB {
	public int minReplacements(String input) {
		if (input.isEmpty()) {
			return 0;
		}
		int[] M = new int[input.length() + 1];
		M[1] = 0;
		int count = 1;
		for (int i = 2; i < M.length; i++) {
			if (input.charAt(i - 1) != input.charAt(i - 2) && input.charAt(i - 1) == 'a') {
				if (count != 1) {
					M[i] = count;
					count = 1;
				} else {
					M[i] = M[i - 1] + 1;
				}
			} else {
				if (input.charAt(i - 1) == input.charAt(i - 2) && input.charAt(i - 1) == 'b') {
					count++;
				} else {
					M[i] = M[i - 1];
				}
			}
		}
		if (count != 1) {
			M[input.length()] = M[input.length() - 1];
		}
		return M[input.length()];
	}

	public static void main(String[] args) {
		ReplacementsOfAAndB sol = new ReplacementsOfAAndB();
		System.out.println(sol.minReplacements("abaabb"));
	}

}
