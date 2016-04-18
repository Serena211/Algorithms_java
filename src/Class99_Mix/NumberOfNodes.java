package Class99_Mix;

import Class05_BFS_Graph.ListNode;

/*
 * Return the number of nodes in the linked list.
 */
public class NumberOfNodes {
	public int numberOfNodes(ListNode head) {
		if (head == null) {
			return 0;
		}
		int count = 0;
		ListNode cur = head;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		// Write your solution here.
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
