package learning;

public class RemoveLinkedListElements {

	class LinkedListNode {
        int val;
        LinkedListNode next;
    };
    
	static LinkedListNode removeAll(int n, LinkedListNode head){
        if(head == null) return null;
        //handle matched values at head
        LinkedListNode tmp = head;
        while(tmp.val == n) {
            if(tmp.next == null) return null;
            tmp = tmp.next;
        }

        head = tmp;
        while(tmp.next != null) {
            if(tmp.next.val == n) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        }
        return head;

        // LinkedListNode begin = new LinkedListNode(0);
        // begin.next = head;
        // LinkedListNode curr = head;
        // while(curr.next != null) {
        //     if(curr.next.val == n) {
        //         curr.next = curr.next.next;
        //     } else {
        //         curr = curr.next;
        //     }
        // }
        // return begin.next;
    }
}
