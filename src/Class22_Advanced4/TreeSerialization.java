package Class22_Advanced4;

import Class05_BFS_Graph.TreeNode;

/* 
 * Given a binary tree, covert it into a Doubly-LinkedList in in-order sequence
 */
//class DLLNode {
//	public int value;
//	public DLLNode next;
//	public DLLNode prev;
//	public DLLNode(int value, DLLNode next, DLLNode prev) {
//		this.value  = value;
//		this.next = null;
//		this.prev = null;
//	}
//}
public class TreeSerialization {
//	DLLNode prev = null;
//	DLLNode head = null;
	TreeNode prev = null;
	TreeNode head = null;
			
	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		if (prev == null) {
//			head = new DLLNode(root.val, prev, null);
			head = root;
			head.left = null;
			prev = head;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		inOrder(root.right);
	}
	public static void main(String[] args) {
		TreeSerialization test = new TreeSerialization();
		TreeNode root = new TreeNode(30);
		TreeNode left1 = new TreeNode(15);
		TreeNode right1 = new TreeNode(45);
		root.left = left1;
		root.right = right1;
		test.inOrder(root);
		while (test.head != null) {
			System.out.println(test.head.val);
			test.head = test.head.right;
		}
	}

}
