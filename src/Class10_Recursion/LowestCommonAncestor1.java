package Class10_Recursion;

import Class05_BFS_Graph.TreeNode;

/*
 * Given two nodes in a binary tree, find their lowest common ancestor.
 * 
 * Assumptions
 * There is no parent pointer for the nodes in the binary tree
 * The given two nodes are guaranteed to be in the binary tree
 */
public class LowestCommonAncestor1 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one,
			TreeNode two) {
		if (root == null || root == one || root == two) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, one, two);
		TreeNode right = lowestCommonAncestor(root.right, one, two);
		if (left != null && right != null) {
			return root;
		} else {
			return left == null? right : left;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		root.left = one;
		one.right = two;
		LowestCommonAncestor1 sol = new LowestCommonAncestor1();
		System.out.println(sol.lowestCommonAncestor(root, one, two).val);
	}

}
