package ex;
/* Questions:
1. what mutable & immutable means? Cannot change String Object!
2. substring after java7
3. Why String is designed as immutable? String s1 = "Welcome"; String s2 = "Welcome";
	s1 = "Hello"; if not immutable, s2 also will be changed.
4. What's the mean of thread-safe?
*/
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.beans.binding.StringBinding;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] myArray1 = {"10","20","30"};
		System.out.println(Arrays.toString(myArray1));
		String[][] myArray2 = {{"10","20","30"},{"10","20","30"}};
		System.out.println(Arrays.deepToString(myArray2));
		
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < myArray1.length; i++) {
			sum1 += Integer.valueOf(myArray1[i]);
			sum2 += Integer.parseInt(myArray1[i]);
		}
		System.out.println(sum1);
		System.out.println(sum2);
		List<Integer> array = new ArrayList<Integer>();
		String sub = new String("asfjoew");
		sub.substring(0, 2);
		StringBuilder sb = new StringBuilder("a");
		StringBuilder sbx = new StringBuilder("a");
		sb.equals(sbx);	// need to override equals();
		sb.setCharAt(0, (char) 1);
	}

}
