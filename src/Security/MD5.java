package Security;

import java.security.*;
import java.math.*;

public class MD5 {
	private static String INPUT = "856ef68d12e6c50f8b4547de50cd13098f38b2a65a74b7c88657df2a7d8c7deeeb9e2fb5ff3be3033d101240656d105880ac17c35f7a51b2948a89aecf25b717c8489c5f91e7ab0069e134d68723f9192498ade2cecb0eb9ac7048ec299dd1bba4d1194b81422e6edb62306995e8aad54f2036b0c68441fbd96873e36c84fbce706a886b308049fe9accb3ba4592ddc5";
	private static final String[] INPUT_ARRAY = splitByNumber(INPUT, 32);
	private static final char[] EMAIL_CHAR = "ZXCVBNMASDFGHJKLQWERTYUIOP@\\|[],<>:;\"zxcvbnmasdfghjklqwertyuiop1234567890!#$%&'*+-/=?^_`{|}~."
			.toCharArray();

	private static String[] splitByNumber(String str, int len) {
		return (len < 1 || str == null) ? null : str.split("(?<=\\G.{" + len
				+ "})");
	}
	
	// generate MD5 code
	private String getMD5Code(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		String rsl = new BigInteger(1, md.digest()).toString(16);
		return rsl.length() == 32 ? rsl : "0" + rsl;
	}

	public String getEmail(String INPUT, String[] INPUT_ARRAY, char[] EMAIL_CHAR)
			throws NoSuchAlgorithmException {
		String email = "";
		for (String target : INPUT_ARRAY) {
			String cur = "";
			for (char c1 : EMAIL_CHAR) {
				for (char c2 : EMAIL_CHAR) {
					String temp = email + c1 + c2;
					String md5 = getMD5Code(temp + getMD5Code(temp));
					if (md5.equals(target)) {
						cur = "" + c1 + c2;
						break;
					}
				}
				if (cur.length() > 0) {
					break;
				}
			}
			if (cur.length() == 0) {
				System.out.println("No such input!");
			} else {
				email += cur;
			}
		}
		return email;
		// System.out.println(email);
	}

	public static void main(String args[]) throws NoSuchAlgorithmException {
		MD5 input = new MD5();
		System.out.println(input.getEmail(MD5.INPUT, MD5.INPUT_ARRAY,
				MD5.EMAIL_CHAR));
	}
}
