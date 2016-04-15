package Class04_BinaryTree;

import java.util.ArrayList;
import java.util.List;

import Class05_BFS_Graph.TreeNode;

/*
 * Get the list of keys in a given binary search tree in a given range[min, max] 
 * in ascending order, both min and max are inclusive.
 * 
 * Corner Cases
 * What if there are no keys in the given range? Return an empty list in this case.
 */
public class GetKeysInBinarySearchTreeInGivenRange {
	public List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> rsl = new ArrayList<Integer>();
		if (root == null || min > max) {
			return rsl;
		}
		getRange(root, min, max, rsl);
		return rsl;
	}

	private void getRange(TreeNode root, int min, int max, List<Integer> rsl) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		// Step1: determin whether go left
		if (root.val > min) {
			getRange(root.left, min, max, rsl);
		}
		// Step2: determine whether print value
		if (root.val >= min && root.val <= max) {
			rsl.add(root.val);
		}
		// Step3: determine whether go right
		if (root.val < max) {
			getRange(root.right, min, max, rsl);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
