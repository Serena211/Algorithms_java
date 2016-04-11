package Class07_Hashtable_String1;

/*
 * Repeatedly remove all adjacent, repeated characters in a given 
 * string from left to right.
 * 
 * No adjacent characters should be identified in the final string.
 * 
 * Examples
 * "abbbaaccz" → "aaaccz" → "ccz" → "z"
 * "aabccdc" → "bccdc" → "bdc"
 * "abbaaab" → "aaaab" → "b"
 */
public class RemoveAdjacentRepeatedCharacters4 {
	// using stack
	public String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] in = input.toCharArray();
		int end = 0;	// return [0, end]
		int pointer = 1;
		while (pointer < in.length) {
			if (end == -1 || in[pointer] != in[end]) {
				in[++end] = in[pointer++];
			} else {
				while (pointer < in.length && in[pointer] == in[end]) {
					pointer++;
				}
				end--;
			}
			
		}
		return  new String(in, 0, end+1) ;
	}

	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharacters4 sol = new RemoveAdjacentRepeatedCharacters4();
		System.out.println(sol.deDup("abbaaab"));
	}

}
