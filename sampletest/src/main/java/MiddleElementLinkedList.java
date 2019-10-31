public class MiddleElementLinkedList {

	
	public class Node {
		private int data;
		private Node nextNode;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public Node middleNode(Node head) {
		Node slowNode = head;
		Node fastNode = head;
		while (fastNode != null && fastNode.nextNode != null) {
			slowNode = slowNode.nextNode;
			fastNode = fastNode.nextNode.nextNode;
		}
		return slowNode;
	}
	
	
	
}
