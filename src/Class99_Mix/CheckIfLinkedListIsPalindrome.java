package Class99_Mix;

import Class05_BFS_Graph.ListNode;

/*
 * Given a linked list, check whether it is a palindrome.
 * 
 * Examples:
 * Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
 * output: true.
 * Input:   1 -> 2 -> 3 -> null  
 * output: false.
 * 
 * Requirements:
 * Space complexity must be O(1)
 */

public class CheckIfLinkedListIsPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		// two pointers find mid listnode
		// get the length of two lists
		ListNode midNode = findMid(head);
		ListNode rightHead = reverse(midNode);
		ListNode leftHead = head;
		// the length of right list no less than the left list
		while (leftHead.next != null) {
			if (leftHead.value != rightHead.value) {
				return false;
			}
			leftHead = leftHead.next;
			rightHead = rightHead.next;
		}
		
		return true;
	}

	private ListNode reverse(ListNode midNode) {
		if (midNode == null) {
			return null;
		}
		ListNode prev = null;
		ListNode cur = midNode;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	private ListNode findMid(ListNode head) {
		// TODO Auto-generated method stub
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next == null) {
			// odd
			return slow;
		}
		if (fast.next != null && fast.next.next == null) {
			return slow.next;
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(1);
//		ListNode e = new ListNode(0);
		a.next = b;
		b.next = c;
		c.next = d;
//		d.next = e;
		CheckIfLinkedListIsPalindrome sol = new CheckIfLinkedListIsPalindrome();
		System.out.println(sol.isPalindrome(a));
	}

}
