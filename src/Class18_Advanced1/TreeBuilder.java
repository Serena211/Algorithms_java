package Class18_Advanced1;

import java.util.Arrays;

import Class05_BFS_Graph.TreeNode;

public class TreeBuilder {
	private Integer[] array;
	private TreeNode[] tree;

	public TreeBuilder(Integer[] arr) {
		array = arr;
	}

	public TreeNode builder() {
		tree = new TreeNode[array.length];
		tree[0] = new TreeNode(array[0]);
		for (int i = 0; i < array.length; i++) {
			TreeNode cur = tree[i];
			if (cur != null && 2 * i + 1 < array.length) {
				if (array[2 * i + 1] != null) {
					cur.left = new TreeNode(array[2 * i + 1]);
				} else {
					cur.left = null;
				}
				tree[2 * i + 1] = cur.left;
			}
			if (cur != null && 2 * i + 2 < array.length) {
				if (array[2 * i + 2] != null) {
					cur.right = new TreeNode(array[2 * i + 2]);
				} else {
					cur.right = null;
				}
				tree[2 * i + 2] = cur.right;
			}
			if (cur == null && 2 * i + 1 < array.length
					&& 2 * i + 2 < array.length
					&& (array[2 * i + 2] != null || array[2 * i + 2] != null)) {
				throw new NullPointerException(
						"if a node == null, it can't have child node");
			}
		}
		return tree[0];
	}

	public void print() {
		System.out.println( Arrays.toString(array));
	}

}
