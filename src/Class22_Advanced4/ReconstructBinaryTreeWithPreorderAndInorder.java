package Class22_Advanced4;

import java.util.HashMap;

import Class05_BFS_Graph.TreeNode;

/*
 * Given the preorder and inorder traversal sequence of a binary tree, reconstruct 
 * the original tree.
 * 
 * Assumptions
 * The given sequences are not null and they have the same length
 * There are no duplicate keys in the binary tree
 * 
 * Examples
 * preorder traversal = {5, 3, 1, 4, 8, 11}
 * inorder traversal = {1, 3, 4, 5, 8, 11}
 * 
 * the corresponding binary tree is

					        5
					
					      /    \
					
					    3        8
					
					  /   \        \
					
					1      4        11
 */

public class ReconstructBinaryTreeWithPreorderAndInorder {
	public TreeNode reconstruct(int[] in, int[] pre) {
		// use hashmap to store (value, index) of int[] in
		HashMap<Integer, Integer> indexOfInOrder = new HashMap<Integer, Integer>();
		for (int i = 0; i < in.length; i++) {
			indexOfInOrder.put(in[i], i);
		}
		
		return helper(0, in.length - 1, pre, 0, pre.length - 1, indexOfInOrder);
	}
	private TreeNode helper(int in_l, int in_r, 
			int[] pre, int pre_l, int pre_r, 
			HashMap<Integer, Integer> map) {
		// base case: 
		if (in_l > in_r) {
			return null;
		}
		
		// recursion rule:
		TreeNode root = new TreeNode(pre[pre_l]);
		int rootIdx = map.get(root.val);
//		int rightSize = pre.length - leftSize - 1;
		root.left = helper(in_l, rootIdx - 1, pre, pre_l + 1, pre_l + (rootIdx - in_l), map);
		root.right = helper(rootIdx + 1, in_r, pre, pre_l + (rootIdx - in_l) + 1, pre_r, map);
		return root;
	}
	public static void main(String[] args) {
		ReconstructBinaryTreeWithPreorderAndInorder sol = new ReconstructBinaryTreeWithPreorderAndInorder();
		System.out.println(sol.reconstruct(new int[]{1,6,5,7,4,10,9},new int[]{4,1,5,6,7,10,9}));
	}

}
