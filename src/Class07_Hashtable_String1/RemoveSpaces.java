package Class07_Hashtable_String1;

/*
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 * 
 * Assumptions:
 * The given string is not null.
 * 
 * Examples:
 * “  a” --> “a”
 * “   I     love MTV ” --> “I love MTV”
 */
public class RemoveSpaces {
	public String removeSpaces(String input) {
		char[] in = input.toCharArray();
		int end = 0;
		int pointer = 0;
		int words = 0;
		while (true) {
			while (pointer < in.length && in[pointer] == ' ') {
				pointer++;
			}
			if (pointer == in.length) {
				break;
			}
			if (words != 0) {
				in[end++] = ' ';
			}
			while (pointer < in.length && in[pointer] != ' ') {
				in[end++] = in[pointer++];
			}
			words++;
		}
		return new String(in, 0, end);
	}

	public static void main(String[] args) {
		RemoveSpaces sol = new RemoveSpaces();
		System.out.println(sol.removeSpaces("  d "));
	}

}
