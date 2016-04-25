package Class99_Mix;

import Class05_BFS_Graph.ListNode;

/*
 * Check if a given linked list has a cycle. Return the node where the cycle starts. 
 * Return null if there is no cycle.
 */

/**
 * class ListNode { public int value; public ListNode next; public ListNode(int
 * value) { this.value = value; next = null; } }
 */

public class CycleNodeInLinkedList {
	public ListNode cycleNode(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while ( slow != fast) {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		CycleNodeInLinkedList sol = new CycleNodeInLinkedList();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println(sol.cycleNode(null));
	}

}
