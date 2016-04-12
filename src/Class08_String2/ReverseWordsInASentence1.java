package Class08_String2;

/*
 * Reverse the words in a sentence.
 * 
 * Assumptions
 * Words are separated by single space
 * There are no heading or tailing white spaces
 * 
 * Examples
 * “I love Google” → “Google love I”
 * 
 * Corner Cases
 * If the given string is null, we do not need to do anything.
 */

public class ReverseWordsInASentence1 {
	public String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] str =  input.toCharArray();
		reverse(str, 0, str.length - 1);
		int left = 0;
		for (int i = 0; i < str.length; i++) {
			if ( i+1 == str.length || str[i+1] == ' ') {
				reverse(str, left, i);
				left = i + 2;
			}
		}
		// Write your solution here.
		return new String(str);
	}

	private void reverse(char[] str, int left, int right) {
		// TODO Auto-generated method stub
		if (left >= right) {
			return;
		}
		while (left < right) {
			swap(str, left, right);
			left++;
			right--;
		}
	}

	private void swap(char[] arr, int i, int j) {
		// TODO Auto-generated method stub
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsInASentence1 sol = new ReverseWordsInASentence1();
		System.out.println(sol.reverseWords("an apple"));
		
	}

}
