package Security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class test {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		String str = "resu";
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(str.getBytes(), 0, str.length());
		String rsl = new BigInteger(1, m.digest()).toString(16);
		rsl = rsl.length() == 32 ? rsl : "0" + rsl;
		System.out.println("MD5: " + rsl);
		System.out.println("TST: 02a76a9b1977a1899865e32af97471cb");

	}
}
