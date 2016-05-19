package Class22_Advanced4;

import java.util.Arrays;
import java.util.HashMap;

import Class05_BFS_Graph.TreeNode;

/*
 * Given the postorder traversal sequence of a binary search tree, reconstruct the 
 * original tree.
 * 
 * Assumptions
 * The given sequence is not null
 * There are no duplicate keys in the binary search tree
 * 
 * Examples
 * postorder traversal = {1, 4, 3, 11, 8, 5}
 * the corresponding binary search tree is

					        5
					
					      /    \
					
					    3        8
					
					  /   \        \
					
					1      4        11
 */

public class ReconstructBinarySearchTreeWithPostorderTraversal {
	public TreeNode reconstruct(int[] post) {
		int[] index = new int[]{post.length - 1};
		return helper(post, index, Integer.MIN_VALUE);
	}

	private TreeNode helper(int[] post, int[] index, int minValue) {
		if (index[0] < 0 || post[index[0]] < minValue) {
			return null;
		}
		TreeNode root= new TreeNode(post[index[0]--]);
		root.right = helper(post, index, root.val);
		root.left = helper(post, index, minValue);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReconstructBinarySearchTreeWithPostorderTraversal sol = new ReconstructBinarySearchTreeWithPostorderTraversal();
		System.out.println(sol.reconstruct(new int[]{1, 4, 3, 11, 8, 5}));
	}

}
