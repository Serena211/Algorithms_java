package Class08_String2;

/*
 * Given a string in compressed form, decompress it to the original string. The 
 * adjacent repeated characters in the original string are compressed to have the 
 * character followed by the number of repeated occurrences. If the character does 
 * not have any adjacent repeated occurrences, it is not compressed.
 * 
 * Assumptions
 * The string is not null
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 * There are no adjacent repeated characters with length > 9
 * 
 * Examples
 * “acb2c4” → “acbbcccc”
 */
public class DecompressString1 {
	public String decompress(String input) {
		if (input.isEmpty()) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		char temp = ' ';
		for (int i = 0; i < input.length(); i++) {
			if (!isDigit(input.charAt(i))) {
				temp = input.charAt(i);
				sb.append(temp);
			} else {
				int num = input.charAt(i) - '0';
				while (num > 1) {
					sb.append(temp);
					num--;
				}

			}
		}
		return sb.toString();
	}

	private boolean isDigit(char c) {
		if (c - '0' <= 9 && c - '0' >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DecompressString1 sol = new DecompressString1();
		System.out.println(sol.decompress("ac2d3ef"));
	}

}
