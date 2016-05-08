package Class21_Advanced3;

import Class05_BFS_Graph.TreeNode;

/*
 * Delete the target key K in the given binary search tree if the binary search 
 * tree contains K. Return the root of the binary search tree.
 * 
 * Find your own way to delete the node from the binary search tree, after deletion 
 * the binary search tree's property should be maintained.
 * 
 * Assumptions
 * There are no duplicate keys in the binary search tree
 */

public class DeleteInBST {
	public TreeNode delete(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		// find the root which need to be deleted
		if (root.val == key) {
			// delete leaf node
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else if (root.left.right == null) {
				root.left.right = root.right;
				return root.left;
			} else {
				TreeNode newNode = findLargestSubtreeNode(root.left);
				root.val = newNode.val;
				return root;
			}
		}
		// what we want get from left child and right child?
		// new root.right node and root.left node, after deleting
		if (root.val > key) {
			root.left = delete(root.left, key);
		} else if (root.val < key) {
			root.right = delete(root.right, key);
		}
		// for current layer, return it to parent node;
		return root;
	}

	private TreeNode findLargestSubtreeNode(TreeNode root) {
		while (root.right.right != null) {
			root = root.right;
		}
		TreeNode rsl = root.right;
		root.right = root.right.left;
		return rsl;
	}

	public static void main(String[] args) {
		DeleteInBST sol = new DeleteInBST();
		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(1);
		root.left = a;
		root.right = b;
		a.left = c;
		System.out.println(sol.delete(root,5));
	}

}
