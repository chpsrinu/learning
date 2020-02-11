package learning;

public class SortedDoubleLinkedListInsertData {

	class DoublyLinkedListNode {
		int data;
		DoublyLinkedListNode next;
		DoublyLinkedListNode prev;
		public DoublyLinkedListNode(int val) {
			this.data=val;
		}
		
	}

	public DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
		DoublyLinkedListNode curr;
		if (head == null) return newNode;
		else if(head.data >= data) {
			newNode.next = head;
			newNode.next.prev=newNode;
			head = newNode;
		} else {
			curr = head;
			while(curr.next!=null && curr.next.data < newNode.data)
				curr = curr.next;
			newNode.next = curr.next;
			if(curr.next != null)
				newNode.next.prev= newNode;
			curr.next= newNode;
			newNode.prev=curr;
		}
		return head;
//		DoublyLinkedListNode pNode = head;
//		DoublyLinkedListNode nNode = head.next;
//		DoublyLinkedListNode curr = head;
//		while (head != null) {
//			if (pNode.data > data && nNode.data < data) {
//				DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
//				// newNode.data = data;
//				pNode.next = newNode;
//				newNode.prev = pNode;
//				newNode.next = nNode;
//				nNode.prev = newNode;
//			} else {
//				pNode = pNode.next;
//				nNode = nNode.next;
//			}
//		}
//		return curr;
	}
	
	public static void main(String[] args) {
//		DoublyLinkedListNode l1 = new DoublyLinkedListNode(1);
//		DoublyLinkedListNode list = new DoublyLinkedListNode()
	}

}
