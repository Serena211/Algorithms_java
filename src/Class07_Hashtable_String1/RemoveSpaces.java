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
		char[] s = input.toCharArray();
		int slow = 0;
		int fast = 0;
		int word = 0;

		while (fast < s.length) {
			if (word > 0 && s[fast] != ' ') {
				s[slow++] = ' ';
			}
			if (s[fast] != ' ') {
				while (fast < s.length && s[fast] != ' ') {
					s[slow++] = s[fast++]; 
				}
				word++;
			} else {
				fast++;
			}
		}

		return new String(s, 0, slow); // array, initial offset, length;
	}

	public static void main(String[] args) {
		RemoveSpaces sol = new RemoveSpaces();
		System.out.println(sol.removeSpaces(" ILove Yahoo"));
//		char[] t = new char[]{'a','b','c'};
//		System.out.println(new String(t,0,2));
	}

}
