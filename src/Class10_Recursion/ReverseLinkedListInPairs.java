package Class10_Recursion;

import Class05_BFS_Graph.ListNode;

/*
 * Reverse pairs of elements in a singly-linked list.
 * 
 * Examples
 * L = null, after reverse is null
 * L = 1 -> null, after reverse is 1 -> null
 * L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
 * L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null
 */
public class ReverseLinkedListInPairs {
	public ListNode reverseInPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = cur.next;
		ListNode nnext = cur.next.next;
		ListNode newHead = reverseInPairs(nnext);
		next.next = cur;
		cur.next = newHead;
		return next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
