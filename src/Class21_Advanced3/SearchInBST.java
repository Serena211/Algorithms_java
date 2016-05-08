package Class21_Advanced3;

import Class05_BFS_Graph.TreeNode;

/*
 * Find the target key K in the given binary search tree, return the node that 
 * contains the key if K is found, otherwise return null.
 * 
 * Assumptions
 * There are no duplicate keys in the binary search tree
 */
public class SearchInBST {
	public TreeNode search(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val > key) {
			return search(root.left, key);
		} else if (root.val < key) {
			return search(root.right, key);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
