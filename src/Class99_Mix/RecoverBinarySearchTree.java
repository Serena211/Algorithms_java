package Class99_Mix;

import Class05_BFS_Graph.TreeNode;

/*
 * Given a Binary Search Tree with only two nodes swapped. Try to find them and 
 * recover the binary search tree.
 */
public class RecoverBinarySearchTree {
	
	public TreeNode switchElement1 = null;
	public TreeNode switchElement2 = null;
	public TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public TreeNode recover(TreeNode root) {
		if (root == null) {
			return root;
		}
		helper(root);
		int temp = switchElement1.key;
		switchElement1.key = switchElement2.key;
		switchElement2.key = temp;
		return root;
	}

	private void helper(TreeNode root) {
		if (root == null) {
			return;
		}
		helper(root.left);
		if (switchElement1 == null && root.key <= prev.key) {
			switchElement1 = new TreeNode(root.key);
			prev.key = switchElement1.key;
		}
		if (switchElement1 != null && root.key <= prev.key) {
			switchElement2 = new TreeNode(root.key);
			prev.key = switchElement2.key;
		}
		helper(root.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
