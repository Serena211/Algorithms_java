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
		// Write your solution here.
		int rsl = root.val;
		
		return helper(root,rsl, target);
	}
//	private TreeNode rsl = null;
//	public int closest(TreeNode root, int target) {
//		int minGap = Math.abs(root.val - target);
//		int gap =helper(root, target, minGap);
//		return rsl.val;
//	}
//
//	private int helper(TreeNode root, int target, int minGap) {
//		if (root == null) {
//			return Integer.MAX_VALUE;
//		}
//		int leftMin = helper(root.left, target, minGap);
//		int rightMin = helper(root.right, target, minGap);
//		int temp = Math.abs(target - root.val); 
//		if (temp < leftMin && temp < rightMin) {
//			minGap = temp;
//			rsl = root;
//		}
//		return Math.min(minGap, Math.min(leftMin, rightMin));
//	}

	private int helper(TreeNode root, int rsl, int target) {
		// TODO Auto-generated method stub
		if (root == null) {
			return rsl;
		}
		if (root.val == target) {
			return root.val;
		}
		if (Math.abs(root.val - target) < Math.abs(rsl - target)) {
			rsl = root.val;
		}
		if (root.val < target) {
			rsl = helper(root.right, rsl, target);
		} else {
			rsl = helper(root.left, rsl, target);
		}
		return rsl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestNumberInBinarySearchTree sol = new ClosestNumberInBinarySearchTree();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(9);
		 TreeNode c = new TreeNode(1);
		 TreeNode e = new TreeNode(14);
		root.left = a;
		root.right = b;
		 a.left = c;
		 b.right = e;

		System.out.println(sol.closest(e, 8));
	}

}
