package Class99_Mix;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string, the other 
 * characters should not be moved or changed.
 * 
 * Assumptions:
 * The given string is not null, and only contains lower case letters.
 * 
 * Examples:
 * "abbegi" --> "ibbega"
 */

public class ReverseOnlyVowels {
	public String reverse(String input) {
		HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
		char[] in = input.toCharArray();
		int start = 0;
		int end = in.length - 1;
		while (start < end) {
			if (vowels.contains(in[start]) && vowels.contains(in[end])) {
				swap(in, start++, end--);
			} else if (vowels.contains(in[start])) {
				end--;
			} else if (vowels.contains(in[end])) {
				start++;
			} else {
				start++;
				end--;
			}			
		} 
		return new String(in);
	}

	private void swap(char[] in, int i, int j) {
		// TODO Auto-generated method stub
		char temp = in[i];
		in[i] = in[j];
		in[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseOnlyVowels sol = new ReverseOnlyVowels();
		System.out.println(sol.reverse(""));
	}

}
