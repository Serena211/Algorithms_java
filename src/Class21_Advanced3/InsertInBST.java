package Class21_Advanced3;

import Class05_BFS_Graph.TreeNode;

/*
 * Insert a key in a binary search tree if the binary search tree does not already 
 * contain the key. Return the root of the binary search tree.
 * 
 * Assumptions
 * There are no duplicate keys in the binary search tree
 * If the key is already existed in the binary search tree, you do not need to do anything
 */
public class InsertInBST {
	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}
		if (root.val < key) {
			root.right = insert(root.right, key);
		} else if (root.val > key) {
			root.left = insert(root.left, key);
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
