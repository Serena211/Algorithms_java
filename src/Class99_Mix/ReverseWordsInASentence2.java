package Class99_Mix;

/*
 * Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.
 * 
 * Examples
 * “ I  love  Google  ” → “Google love I”
 * 
 * Corner Cases
 * If the given string is null, we do not need to do anything.
 */

public class ReverseWordsInASentence2 {
	public String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] in = input.toCharArray();
		char[] words = reverseWords(in, 0, input.length() - 1);
		String newInput = trimSpaces(words, 0, input.length() - 1);

		return newInput;
	}

	private String trimSpaces(char[] input, int l, int r) {
		int wordCount = 0;
		StringBuilder rsl = new StringBuilder();
		while (l <= r) {
			if (input[l] != ' ') {
				if (wordCount != 0) {
					rsl.append(' ');
				}
				while (l <= r && input[l] != ' ') {
					rsl.append(input[l++]);
				}
				wordCount++;
			} else {
				l++;
			}
		}
		return new String(rsl);
	}

	private char[] reverseWords(char[] input, int l, int r) {
		reverse(input, l, r);
		while (l <= r) {
			if (input[l] != ' ') {
				int start = l;
				while (l <= r && input[l] != ' ') {
					l++;
				}
				int end = l == r ? r : l - 1;
				reverse(input, start, end);
			} else {
				l++;
			}
			
		}
		return input;
	}

	private void reverse(char[] input, int l, int r) {
		if (l >= r) {
			return;
		}
		while (l < r) {
			char temp = input[l];
			input[l] = input[r];
			input[r] = temp;
			l++;
			r--;
		}
	}

	public static void main(String[] args) {
		ReverseWordsInASentence2 sol = new ReverseWordsInASentence2();
		System.out.println(sol.reverseWords("  google love   i      "));
	}

}
