package Class99_Mix;

import Class05_BFS_Graph.TreeNode;

/*
 * In a binary search tree, find the node containing the closest number to the given 
 * target number.
 * 
 * Assumptions:
 * The given root is not null.
 * There are no duplicate keys in the binary search tree.
 */

public class ClosestNumberInBinarySearchTree {
	public int closest(TreeNode root, int target) {
		TreeNode rsl = null;
		int minGap = Math.abs(root.val - target);
		return helper(root, target, minGap, rsl);
	}

	private int helper(TreeNode root, int target, int minGap, TreeNode rsl) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int leftMin = helper(root.left, target, minGap, rsl);
		int rightMin = helper(root.right, target, minGap, rsl);
		int temp = Math.abs(target - root.val); 
		if (leftMin < minGap) {
			minGap = leftMin;
			
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestNumberInBinarySearchTree sol = new ClosestNumberInBinarySearchTree();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(3);
		// TreeNode c = new TreeNode(1);
		// TreeNode e = new TreeNode(1);
		root.left = a;
		root.right = b;
		// a.left = c;
		// b.right = e;

		System.out.println(sol.closest(root, 3));
	}

}
