package Class22_Advanced4;

import java.util.ArrayList;
import java.util.List;

import Class05_BFS_Graph.TreeNode;

/*
 * Given a binary tree in which each node contains an integer number. 
 * Determine if there exists a path (the path can only be from one node to itself 
 * or to any of its descendants), the sum of the numbers on the path is the given 
 * target number.
 * 
 * Examples

					    5
					
					  /    \
					
					2      11
					
					     /    \
					
					    6     14
					
					  /
					
					 3

If target = 17, There exists a path 11 + 6, the sum of the path is target.

If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

If target = 10, There does not exist any paths sum of which is target.

If target = 11, There exists a path only containing the node 11.
 */
public class BinaryTreePathSumToTarget {
	public boolean exist(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		List<Integer> path = new ArrayList<Integer>();
		return hasPath(root, target, path);
	}
	private boolean hasPath(TreeNode root, int target, List<Integer> path) {
		if (root == null) {
			return false;
		}
		path.add(root.val);
		if (isTarget(path,target)) {
			return true;
		}
		if (root.left != null && hasPath(root.left, target, path)) {
			return true;
		}
		if (root.right != null && hasPath(root.right, target, path)) {
			return true;
		}
		path.remove(path.size() - 1);
		return false;
	}
	private boolean isTarget(List<Integer> path, int target) {
		int sum = 0;
		for (int i = path.size() - 1; i >= 0; i--) {
			sum += path.get(i);
			if (sum == target) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
