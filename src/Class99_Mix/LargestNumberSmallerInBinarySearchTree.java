package Class99_Mix;

import Class05_BFS_Graph.TreeNode;

/*
 * In a binary search tree, find the node containing the largest number smaller 
 * than the given target number.
 * 
 * If there is no such number, return INT_MIN.
 * 
 * Assumptions:
 * The given root is not null.
 * There are no duplicate keys in the binary search tree.
 */

public class LargestNumberSmallerInBinarySearchTree {
	public int largestSmaller(TreeNode root, int target) {
		int rsl = Integer.MIN_VALUE;
		return helper(root, target, rsl);
	}

	private int helper(TreeNode root, int target, int rsl) {
		if (root == null) {
			return rsl;
		}
		int curGap = target - root.val;
		int minGap = Math.abs(target - rsl);
		if (curGap > 0 && curGap < minGap) {
			rsl = root.val;
		}
		if (root.val < target) {
			rsl = helper(root.right, target, rsl);
		} else {
			rsl = helper(root.left,target ,rsl);
		}
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumberSmallerInBinarySearchTree sol = new LargestNumberSmallerInBinarySearchTree();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(9);
		 TreeNode c = new TreeNode(1);
		 TreeNode e = new TreeNode(14);
		root.left = a;
		root.right = b;
		 a.left = c;
		 b.right = e;

		System.out.println(sol.largestSmaller(root, 8));
	}

}
