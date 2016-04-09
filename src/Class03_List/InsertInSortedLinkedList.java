package Class03_List;

import Class05_BFS_Graph.ListNode;

/*
 * Insert a value in a sorted linked list.
 * 
 * Examples
 * L = null, insert 1, return 1 -> null
 * L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
 * L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
 * L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
 */

public class InsertInSortedLinkedList {
	public ListNode insert(ListNode head, int value) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode cur = dummy;
		ListNode newNode = new ListNode(value);
		while (cur.next != null && cur.next.value < value) {
			cur = cur.next;
		}
		if (cur.value <= value) {
			newNode.next = cur.next;
			cur.next = newNode;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		InsertInSortedLinkedList sol = new InsertInSortedLinkedList();
		ListNode h = sol.insert(a,9);
		while (h!= null) {
			System.out.println(h.value);
			h = h.next;
		}
	}

}
