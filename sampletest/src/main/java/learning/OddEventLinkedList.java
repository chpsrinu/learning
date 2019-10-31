package learning;

public class OddEventLinkedList {

	public class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	public Node oddEvenList(Node head) {
		if (head == null) return null;
		Node odd = head;
		Node even = head.next;
		Node evenHead = even;
		
		while (even != null && evenHead != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}
}
