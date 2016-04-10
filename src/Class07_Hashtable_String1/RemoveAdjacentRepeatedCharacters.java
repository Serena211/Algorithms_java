package Class07_Hashtable_String1;

/*
 * Remove adjacent, repeated characters in a given string, leaving only 
 * one character for each group of such characters.
 * 
 * Assumptions
 * Try to do it in place.
 * 
 * Examples
 * “aaaabbbc” is transferred to “abc”
 * 
 * Corner Cases
 * If the given string is null, we do not need to do anything.
 */

public class RemoveAdjacentRepeatedCharacters {
	public String deDup(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] in = input.toCharArray();
		int slow = 0;	//[0,slow] are output
		int fast = 1;	// to explore unknown zone (slow, array.length - 1]
		int flag = 0;
		while (fast < in.length) {
			if (in[fast] != in[slow]) {
				in[++slow] = in[fast++];
			} else {
				fast++;
			}
			
		} 
		return new String(in, 0, slow + 1); // [0,x)
	}

	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharacters sol = new RemoveAdjacentRepeatedCharacters();
		System.out.println(sol.deDup("aaaassdb"));
	}

}
