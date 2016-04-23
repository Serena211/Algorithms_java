package Class99_Mix;

import Class05_BFS_Graph.TreeNode;

public class HeightofBinaryTree {
	public int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = findHeight(root.left);
		int right = findHeight(root.right);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
