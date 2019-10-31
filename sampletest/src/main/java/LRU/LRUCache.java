package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private int actualSize;
	private Map<Integer, Node> map;
	private DoubleLinkedList linkedList;
	
	public LRUCache() {
		this.map = new HashMap<Integer, Node>();
		this.linkedList = new DoubleLinkedList();
	}
	public void put(int id, String data) {
		
		//update the node if already exists
		if(map.containsKey(id)) {
			Node node = map.get(id);
			node.setData(data);
			//update the node to be the head (cache feature)
			update(node);
			return;
		}
		//this data is not present in the cache so insert
		Node node = new Node(id, data);
		
		//we have to insert into the cache + set it to the headNode
		if(this.actualSize<Constants.CAPACITY) {
			this.actualSize++;
			add(node);
		} else {
			//or the cache is full, we have to remove the last item+ insert new node
			removeTail();
			add(node);
		}
	}
	
	private void add(Node node) {
		node.setNextNode(this.linkedList.getHeadNode());
		node.setPreviousNode(null);
		
		if(this.linkedList.getHeadNode() != null) {
			this.linkedList.getHeadNode().setPreviousNode(node);
		}
		this.linkedList.setHeadNode(node);
		if(this.linkedList.getTailNode() == null) {
			this.linkedList.setTailNode(node);
		}
		this.map.put(node.getId(), node);
	}
	
	private void removeTail() {
		Node lastNode = this.map.get(this.linkedList.getTailNode().getId());
		this.linkedList.setTailNode(this.linkedList.getTailNode().getPreviousNode());
		if(this.linkedList.getTailNode() != null)
			this.linkedList.getTailNode().setNextNode(null);
		lastNode = null;
	}
	
	public Node get(int id) {
		if(!this.map.containsKey(id)) return null;
		
		Node node = this.map.get(id);
		update(node);
		return node;
	}
	
	private void update(Node node) {
		Node previousNode = node.getPreviousNode();
		Node nextNode = node.getNextNode();
		
		//so it is a middle node in the list 
		if(previousNode!=null)
			previousNode.setNextNode(nextNode);
		else //this is head node
			this.linkedList.setHeadNode(nextNode);
		
		if(nextNode != null)
			nextNode.setPreviousNode(previousNode);
		else
			this.linkedList.setTailNode(previousNode);
		
		add(node);
	}
	
	public void show() {
		Node actualNode = this.linkedList.getHeadNode();
		
		while(actualNode!=null) {
			System.out.println(actualNode+"<->");
			actualNode = actualNode.getNextNode();
		}
		
	}
}
