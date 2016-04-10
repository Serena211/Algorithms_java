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
 */
public class RemoveAdjacentRepeatedCharacters4 {
	// using stack
	public String deDup(String input) {
		if (input == null || input.length() == 0 || input.length() == 1) {
			return input;
		}
		char[] in = input.toCharArray();
		int top = 0;		// return [0, top]
		int newChar = 1;	// explore zone (top, array.length - 1]
		while (newChar < in.length) {
			if (in[newChar] == in[top]) {
				while (in[newChar] == in[top]) {
					newChar++;
				}
				top--;
			} else {
				in[++top] = in[newChar++];
			}
		}
		return top < 0 ? new String("") : new String(in, 0, top + 1) ;
	}

	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharacters4 sol = new RemoveAdjacentRepeatedCharacters4();
		System.out.println(sol.deDup("abbaaac"));
	}

}
