package Class05_BFS_Graph;

import java.util.Deque;
import java.util.LinkedList;

/* Check if a given binary tree is completed. 
 * A complete binary tree is one in which every 
 * level of the binary tree is completely filled 
 * except possibly the last level. Furthermore, 
 * all nodes are as far left as possible.
 * 
 * Corner Cases
 * What if the binary tree is null? 
 * Return true in this case.
 * 
 * How is the binary tree represented?
 * We use the level order traversal sequence with 
 * a special symbol "#" denoting the null node.
*/

public class isCompletedBinaryTree {
	public boolean isCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offerLast(root);
		boolean flag = false;
		while(!queue.isEmpty()) {
			TreeNode cur = queue.pollFirst();
			if (cur.left == null) {
				flag = true;
			} else if (flag == true) {
				return false;
			} else {
				queue.offerLast(cur.left);
			}
			
			if (cur.right == null) {
				flag = true;
			} else if(flag == true) {
				return false;
			} else {
				queue.offerLast(cur.right);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
