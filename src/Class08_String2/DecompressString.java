package Class08_String2;

/*
 * Given a string in compressed form, decompress it to the original string. 
 * The adjacent repeated characters in the original string are compressed to 
 * have the character followed by the number of repeated occurrences.
 * 
 * Assumptions
 * The string is not null
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 * There are no adjacent repeated characters with length > 9
 * 
 * Examples
 * “a1c0b2c4” → “abbcccc”
 */
public class DecompressString {
	public String decompress(String input) {
		if (input == null || input.length() == 0 || input.length() % 2 == 1) {
			return "";
		}
		char temp = ' ';
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (i % 2 == 0) {
				if (isDigit(input.charAt(i))) {
					return "";
				}
				temp = input.charAt(i);
			} else {
				if (!isDigit(input.charAt(i))) {
					return "";
				}
				int num = input.charAt(i) - '0';
				while (num > 0) {
					sb.append(temp);
					num--;
				}
			}
		}
		return sb.toString();
	}
	private boolean isDigit(char c) {
		if (c - '0' <0 || c - '0' > 9) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		DecompressString sol = new DecompressString();
		System.out.println(sol.decompress("a2b0c1d0e1f3"));
	}

}
