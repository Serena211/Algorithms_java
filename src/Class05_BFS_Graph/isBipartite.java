package Class05_BFS_Graph;

/*	Determine if an undirected graph is bipartite. 
	A bipartite graph is one in which the nodes can 
	be divided into two groups such that no nodes 
	have direct edges to other nodes in the same group.
	
	Assumptions:
	The graph is represented by a list of nodes, 
	and the list of nodes is not null.
*/

import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

public class isBipartite {
	public boolean bipartite(List<GraphNode> graph) {
		if (graph == null) {
			return true;
		}
		Hashtable<GraphNode, Integer> map = new Hashtable<GraphNode, Integer>();
		for (GraphNode node : graph) {
			if (isConflict(node, map)) {
				return false;
			}
		}
		return true;
	  }
	private boolean isConflict(GraphNode node, Hashtable<GraphNode, Integer> map) {
		if (map.containsKey(node)) {
			// if no conflict after traversing the graph to 
			// last node, return false, means no conflict
			return false;
		}
		// This queue is used to store nodes, expand and generate new one
		Deque<GraphNode> queue = new LinkedList<GraphNode>();
		map.put(node, 0);	//sign of first node is 0
		queue.offerLast(node);	//add to the queue
		while(!queue.isEmpty()) {
			GraphNode cur = queue.pollFirst();
			int curSign = map.get(cur);
			int nbSign = curSign == 1? 0 : 1;
			for(GraphNode n : cur.neighbors) {
				if(!map.containsKey(n)) {
					map.put(n, nbSign);
					queue.offerLast(n);
				} else if (map.get(n) != nbSign) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
