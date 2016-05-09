package Class21_Advanced3;

import Class05_BFS_Graph.ListNode;

public class ListBuilder {
	public ListNode listBuilder(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		for (int i = 0; i < array.length; i++) {
			cur.next = new ListNode(array[i]);
			cur = cur.next;
			
		}
		return dummy.next;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ListBuilder list = new ListBuilder();
//		ListNode list1 = list.listBuilder(new int[]{1,3,5,6,8});
		
//		ListNode list2 = list.listBuilder(new int[]{1,3,4,0,8});
//		while (list2 != null) {
//			System.out.println(list2.value);
//			list2 = list2.next;
//		}

	}

}
