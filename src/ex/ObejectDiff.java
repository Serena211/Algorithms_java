package ex;

import java.util.Arrays;
import java.util.List;

public class ObejectDiff {
	public static void printList1(List<Object> list) {
		int[] array = new int[-3];
		for (Object obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}
	
	// List<?> is equals to <? extends Object>
	public static void printList2(List<?> list) {
		for (Object obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {		
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String> ls = Arrays.asList("I", "am", "hungry");
		
		//because neither List<Integer> nor List<String> is a subtype of List<Object>
		//printList1(li);
		//printList1(ls);
		
	    printList2(li);
		printList2(ls);

		//only List<Object> is a subtype of List<Object>
		List<Object> lo = Arrays.asList(1, "one", 'a');
		printList1(lo);		
	}
}
