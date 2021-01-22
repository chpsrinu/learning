package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

	class Node {
	    public int val;
	    public List<Node> neighbors;
	    
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }
	
	private Node clone(Node src, HashMap<Node, Node> visitedBag) {
		if (src == null) return null;
		
		if(visitedBag.containsKey(src)) return visitedBag.get(src);
		
		Node n = new Node(src.val);
		visitedBag.put(src, n);
		for(Node child: src.neighbors) {
			if(visitedBag.containsKey(child)) {
				n.neighbors.add(child);
			} else {
				Node childCopy = clone(child,visitedBag);
				n.neighbors.add(childCopy);
			}
		}
		return n;
	}
	
}
