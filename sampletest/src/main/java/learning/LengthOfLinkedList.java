package learning;

class Node {
	int data;
	Node nextNode;
	
	public Node(int data) {
		this.data = data;
	}
}

public class LengthOfLinkedList {

	public int lenghtOfLL(Node node) {
		int count = 0;
		while(node != null) {
			count++;
			node = node.nextNode;
		}
		return count;
	}
	
	public int lengthOfLLR(Node node) {
		if (node == null)
			return 0;
		return 1+lengthOfLLR(node.nextNode);
	}
}
