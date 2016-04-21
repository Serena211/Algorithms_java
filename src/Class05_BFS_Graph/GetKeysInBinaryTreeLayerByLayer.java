package Class05_BFS_Graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* Get the list of list of keys in a given binary tree 
 * layer by layer. Each layer is represented by a list 
 * of keys and the keys are traversed from left to right.
 * Examples
 *      			 5

			      /    \
			
			    3        8
			
			  /   \        \
			
			 1     4        11
 * the result is [ [5], [3, 8], [1, 4, 11] ]
 * 
 * Corner Cases:
 * What if the binary tree is null? 
 * Return an empty list of list in this case.
 * 
 * How is the binary tree represented?
 * We use the level order traversal sequence with a 
 * special symbol "#" denoting the null node.
 * */
public class GetKeysInBinaryTreeLayerByLayer {
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) {
			return result;
		}
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> curLayer = new ArrayList<Integer>();
			while(size > 0) {
				TreeNode cur = queue.poll();
				curLayer.add(cur.val);
				if(cur.left != null) {
					queue.offer(cur.left);
				}
				if(cur.right != null) {
					queue.offer(cur.right);
				}
				size--;
			}
			result.add(curLayer);
			
		}
		return result;
	}
}
