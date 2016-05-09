package Class21_Advanced3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import Class05_BFS_Graph.ListNode;

/*
 * Merge K sorted lists into one big sorted list in ascending order.
 * 
 * Assumptions
 * ListOfLists is not null, and none of the lists is null.
 */

public class MergeKSortedLists {
	static class Element {
		public int val;
		public ListNode node;
		public Element(int v, ListNode n) {
			val = v;
			node = n;
		}
	}
	public ListNode merge(List<ListNode> listOfLists) {
		if (listOfLists.size() == 0) {
			return null;
		}
		int K = listOfLists.size();		// count how many sorted lists
		ListNode dummyNode = new ListNode(0);
		ListNode cur = dummyNode;
		Comparator<Element> listComparator = new Comparator<Element>() {


			@Override
			public int compare(Element o1, Element o2) {
				if (o1.val == o2.val) {
					return 0;
				}
				return o1.val < o2.val ? -1 : 1;
			}
		};
		PriorityQueue<Element> min = new PriorityQueue<Element>(K, listComparator);
		
		for (int i = 0; i < K; i++) {
			if (listOfLists.get(i) != null) {
				min.offer(new Element(listOfLists.get(i).value,listOfLists.get(i)));
			}
		}
		while (!min.isEmpty()) {
			Element temp = min.peek();
			cur.next = temp.node;
			cur = cur.next;
			min.poll();
			
			// add next node into priority queue
			if (temp.node.next != null) {
				min.offer(new Element(temp.node.next.value, temp.node.next));
			}
		}
		return dummyNode.next;
	}

	public static void main(String[] args) {
		MergeKSortedLists sol = new MergeKSortedLists();
		ListBuilder list = new ListBuilder();
		ListNode list1 = list.listBuilder(new int[]{1,3,5,6,8});
		ListNode list2 = list.listBuilder(new int[]{1,10});
		ListNode list3 = list.listBuilder(new int[]{0,2,7});
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		ListNode rsl = sol.merge(lists);
		while (rsl != null) {
			System.out.println(rsl.value);
			rsl = rsl.next;
		}
//		System.out.println(sol.merge(lists));
	}

}
