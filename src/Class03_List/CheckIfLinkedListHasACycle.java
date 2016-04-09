package Class03_List;

import Class05_BFS_Graph.ListNode;

/*
 * Check if a given linked list has a cycle. 
 * Return true if it does, otherwise return false.
 */
public class CheckIfLinkedListHasACycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != null && fast != null) {
			if (fast == slow) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
