package Class03_List;

import Class05_BFS_Graph.ListNode;

/*
 * Reverse a singly-linked list.
 * 
 * Examples
 * L = null, return null
 * L = 1 -> null, return 1 -> null
 * L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null
 * */

public class ReverseLinkedList {
	public ListNode reverseItr(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode prev = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	public ListNode reverseRec(ListNode head) {
		//base case: 
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverseRec(head.next);
		head.next.next  = head;
		head.next = null;
		
		return newHead;
	  }
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		ReverseLinkedList sol = new ReverseLinkedList();
		ListNode h = sol.reverse(a);
		while (h!= null) {
			System.out.println(h.value);
			h = h.next;
		}

		
	}

}
