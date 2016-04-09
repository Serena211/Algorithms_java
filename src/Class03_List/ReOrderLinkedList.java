package Class03_List;

import Class05_BFS_Graph.ListNode;

/*Reorder the given singly-linked list 
 * N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be 
 * N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null
 * 
 * */
public class ReOrderLinkedList {
	public ListNode reorder(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMid(head);
		ListNode newMid = reverse(mid);
		ListNode newHead = merge(head, newMid);
		return newHead;
	}
	private ListNode merge(ListNode one, ListNode two) {
		ListNode head =  one;
		while (one != null && two != null) {
			ListNode cur1 = one.next;
			ListNode cur2 = two.next;
			one.next = two;
			two.next = cur1;
			one = cur1;
			two = cur2;
		}
		return head;
		
	}
	private ListNode reverse(ListNode head) {
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
	private ListNode findMid(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(6);
		a.next = b;
//		b.next = c;
//		c.next = d;
//		d.next = e;
		ReOrderLinkedList sol = new ReOrderLinkedList();
		ListNode h = sol.reorder(a);
		while (h!= null) {
			System.out.println(h.value);
			h = h.next;
		}
	}

}
