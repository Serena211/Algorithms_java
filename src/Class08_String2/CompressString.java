package Class08_String2;

/*
 * Given a string, replace adjacent, repeated characters with the character 
 * followed by the number of repeated occurrences. If the character does not 
 * has any adjacent, repeated occurrences, it is not changed.
 * 
 * Assumptions
 * The string is not null
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 * There are no adjacent repeated characters with length > 9
 * 
 * Examples
 * “abbcccdeee” → “ab2c3de3”
 */

public class CompressString {
	public String compress(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(input.charAt(0));
		int slow = 0;
		int fast = 1;
		int count = 1;
		while (fast < input.length()) {
			if (input.charAt(slow) == input.charAt(fast)) {
				while (fast < input.length() && input.charAt(slow) == input.charAt(fast)) {
					count++;
					fast++;
				}
				sb.append(String.valueOf(count));
//				slow = fast++;
				count = 1;
			} else {
				sb.append(input.charAt(fast));
				slow = fast++;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		CompressString sol = new CompressString();
		System.out.println(sol.compress("1"));
	}

}
