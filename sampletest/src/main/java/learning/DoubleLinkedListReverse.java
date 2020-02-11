package learning;

public class DoubleLinkedListReverse {

	class Node {
		int val;
		Node prev;
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public static Node reverseLinkedList(Node head) {
		Node pNode = null;
		
		while (head != null) {
			Node tempNode = head.next;
			head.next = pNode;
			head.prev = tempNode;
			pNode = head;
			head = tempNode;
		}
		return pNode;
	}
}
