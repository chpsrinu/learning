package learning;

public class LinkedListInsertDataPosition {

	 class SinglyLinkedListNode {
          int data;
          SinglyLinkedListNode next;
          public SinglyLinkedListNode(int val) {
        	  this.data = val;
		}
      }
     
     
    public SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode root = head;
        if (head == null) return null;
        else if(position == 0) {
            //SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next=head;
            head = newNode;
            return head;
        } else {
            int count= 0;
            SinglyLinkedListNode pNode = null;
            while(head!=null) {
                if (count < position) {
                    pNode = head;
                    head = head.next;
                    count++;
                }    
                if (count == position) {
                    pNode.next = newNode;
                    newNode.next = head;
                    return root;
                }
            }
            if (count < position) return null;
        }
        return null;
    }
}
