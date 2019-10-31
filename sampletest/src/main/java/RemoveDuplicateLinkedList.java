import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateLinkedList {

	static class Node {
		int val;
		Node next;
		
		public Node(int val) {
			this.val = val;
		}
	}
	
	static Node removeDuplicate2(Node head) {
		Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        
        while(prev.next != null && prev.next.next != null) {
            if(prev.next.val == prev.next.next.val) {
                int dup = prev.next.val;
                while(prev.next !=null && prev.next.val == dup) {
                    prev.next = prev.next.next;
                }
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
	}
	
	static Node removeDuplciate(Node head) {
		List<Integer> set = new ArrayList<>();
		
		Node curr = head;
		Node prev = null;
		
		while(curr != null) {
			if(set.contains(curr.val)) {
				prev.next = curr.next;
			} else {
				set.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
		
	}
}
