package Class09_BitOperations;

/*
 * Generate the hexadecimal representation for a given non-negative integer 
 * number as a string. The hex representation should start with "0x".
 * 
 * There should not be extra zeros on the left side.
 * 
 * Examples
 * 0's hex representation is "0x0"
 * 255's hex representation is "0xFF"
 */

public class HexRepresentation {
	public String hex(int number) {
		if (number == 0) {
			return new String("0x0");
		}		
		StringBuilder sb = new StringBuilder();
		String hexa = decToHexa(number, sb);
		return hexa;
	}

	private String decToHexa(int number, StringBuilder sb) {
		char[] charTable = new char[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while (number != 0) {
			int index = (15 & number);
			sb.append(charTable[index]);
			number >>>= 4;
		}
		sb.append("x0");
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HexRepresentation sol = new HexRepresentation();
		System.out.println(sol.hex(4096));
	}

}
