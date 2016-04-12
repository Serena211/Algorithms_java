package Class08_String2;

/*
 * Right shift a given string by n characters.
 * 
 * Assumptions
 * The given string is not null.
 * n >= 0.
 */

public class RightShiftByNCharacters {
	public String rightShift(String input, int n) {
		if (input.length() <= 1 || n == 0) {
			return input;
		}
/*		if (n > input.length()) {
			  n = n % input.length();
		}*/
		 n = n % input.length();
		char[] str = input.toCharArray();
		reverse(str, 0, str.length - 1);
		reverse(str, 0, n - 1);
		reverse(str, n, str.length - 1);
		return new String(str);
	}

	private void reverse(char[] str, int i, int j) {
		while(i < j) {
			swap(str, i++, j--);	
		}
	}

	private void swap(char[] arr, int i, int j) {
		// TODO Auto-generated method stub
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		RightShiftByNCharacters sol = new RightShiftByNCharacters();
		System.out.println(sol.rightShift("abcdef", 2));
	}

}
