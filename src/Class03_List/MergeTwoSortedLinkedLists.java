package Class03_List;

import Class05_BFS_Graph.ListNode;

/*
 * 	Merge two sorted lists into one large sorted list.
 * 
 * 	Examples
 * 	L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, 
	merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
 * 	L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
 * 	L1 = null, L2 = null, merge L1 and L2 to null
 */
public class MergeTwoSortedLinkedLists {
	public ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one != null && two != null) {
			if(one.value < two.value) {
				cur.next = one;
				one = one.next;
			} else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		if (one == null) {
			cur.next = two;
		} else {
			cur.next = one;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
