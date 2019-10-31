public class LinkedListReverse {

	public class Node {
		private int data;
		private Node nextNode;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public Node reverseLinkedList(Node head) {
		Node currNode = head;
		Node prevNode = head;
		while(currNode != null) {
			Node tempNode = currNode.nextNode;
			currNode.nextNode = prevNode;
			prevNode = currNode;
			currNode = tempNode;
		}
		return prevNode;
	}
	
	public Node reverseRecursiveLinkedList(Node head) {
		if (head == null || head.nextNode == null) return head;
		Node p = reverseRecursiveLinkedList(head.nextNode);
		head.nextNode.nextNode = head;
		head.nextNode = null;
		return p;
	}
}
