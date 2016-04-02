package Class03_List;

import Class05_BFS_Graph.ListNode;

/*Given a linked list and a target value T, partition it 
 * such that all nodes less than T are listed before the 
 * nodes larger than or equal to target value T. The original 
 * relative order of the nodes in each of the two partitions 
 * should be preserved.
 * 
 * Examples
 * L = 2 -> 4 -> 3 -> 5 -> 1 -> null, T = 3, 
 * is partitioned to 2 -> 1 -> 4 -> 3 -> 5 -> null
 * 
 * */
public class PartitionLinkedList {
	public static ListNode partition(ListNode head, int target) {
		if (head == null) {
			return head;
		}
		ListNode dummySmall = new ListNode(0);
		ListNode dummyLarge = new ListNode(0);
		ListNode smallTail = dummySmall;
		ListNode largeTail = dummyLarge;
		while(head != null) {
			if(head.value < target) {
				smallTail.next = head;
				smallTail = smallTail.next;
			} else {
				largeTail.next = head;
				largeTail = largeTail.next;
			}
			head = head.next;
		}
		smallTail.next = dummyLarge.next;
		largeTail.next = null;
		return dummySmall.next;
	}
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(1);
		ListNode e = new ListNode(6);
		a.next = b;
		b.next = c;
		d.next = e;
		c.next = d;
		ListNode h = partition(a,3);
		while (h!= null) {
			System.out.println(h.value);
			h = h.next;
		}

	}

}
