package Class08_String2;

/*
 * Given an original string input, and two strings S and T, replace all 
 * occurrences of S in input with T.
 * 
 * Assumptions
 * input, S and T are not null, S is not empty string
 * 
 * Examples
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "dodododo", S = "dod", T = "a", input becomes "aoao"
 */

public class StringReplace {
	public String replace(String input, String s, String t) {

		return input;
	}

	public String removeSpaces(String input) {
		// if an input string only contains “ ” two blank spaces, return “ ”;
		char[] in = input.toCharArray();
		if (in == null || in.length <= 1) {
			return new String(in);
		}
		int word = 0;
		int slow = 0;
		int fast = 0;
		int space = 0;
		while (fast < in.length) {
			if (word == 0 && in[fast] == ' ') {
				fast++;
			} else if (word == 0 && in[fast] != ' ') {
				while (fast < in.length && in[fast] != ' ') {
					in[slow++] = in[fast++];
				}
				word++;
			} else if (word > 0 && space == 0 && in[fast] == ' ') {
				space = 1;
				in[slow++] = in[fast++];
			} else if (word > 0 && space != 0 && in[fast] == ' ') {
				fast++;
			} else {
				space = 0;
				while (fast < in.length && in[fast] != ' ') {
					in[slow++] = in[fast++];
				}
				word++;
			}
		}
		return new String(in, slow, fast);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
