package Class05_BFS_Graph;

public class STACK {
	public STACK() {
		head = null;  //if no misunderstanding use "head", this.head = head or head = h
	}
	private ListNode head;
	//offer, peek, pop
	public void offer(Integer e) {
		if (head == null) {
			head = new ListNode(e);
		} else {
			ListNode cur = new ListNode(e);
			cur.next = head;
		}
	}
	public Integer peek() {
		if(head == null) {
			return null;
		}
		return head.value;
	}
	public Integer pop() {
		if (head == null) {
			return null;
		}
		ListNode cur = head;
		cur.next = null;
		head = head.next;
		return cur.value;
	}
}
