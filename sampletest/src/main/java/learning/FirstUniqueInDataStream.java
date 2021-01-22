package learning;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/discuss/interview-question/algorithms/124822/bloomberg-interview-question-find-first-unique-integer-in-a-stream
public class FirstUniqueInDataStream {

	private ListNode head = new ListNode(999);
	private ListNode tail = new ListNode(999);
	private Map<Integer, ListNode> map;
	private int nodescount;
	
	public FirstUniqueInDataStream() {
		this.map = new HashMap<>();
		head.next = tail;
		tail.previous = head;
		this.nodescount = 0;
	}
	
	public void add(int num) {
		if(map.containsKey(num)) {
			ListNode node = map.get(num);
			deleteNode(node);
		} else {
			ListNode newNode = new ListNode(num);
			map.put(num, newNode);
			insertAtTail(newNode);
		}
	}
	
	private void deleteNode(ListNode node) {
		ListNode next = node.next;
		ListNode previous = node.previous;
		if(previous != null && next != null) {
			previous.next = next;
			next.previous = previous;
			node.next = null;
			node.previous = null;
			nodescount--;
		}
	}
	
	private boolean isEmpty() {
		return nodescount == 0;
	}
	
	public Integer getFirstUnique() {
		if(isEmpty()) return null;
		return head.next.value;
	}
	
	private void insertAtTail(ListNode node) {
		ListNode previous = tail.previous;
		tail.previous = node;
		node.next = tail;
		previous.next = node;
		node.previous = previous;
		nodescount++;
	}
	
	class ListNode {
		private int value;
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

		public ListNode getPrevious() {
			return previous;
		}

		public void setPrevious(ListNode previous) {
			this.previous = previous;
		}
	}
	
	public static void main(String[] args) {
		FirstUniqueInDataStream s = new FirstUniqueInDataStream();
		
		s.add(2);
		System.out.println(s.getFirstUnique());
        //assert s.getFirstUnique() == 2;
        s.add(2);
        System.out.println(s.getFirstUnique());
        //assert s.getFirstUnique() == null;
        s.add(3);
        System.out.println(s.getFirstUnique());
        //assert s.getFirstUnique() == 3;
        s.add(4);
        System.out.println(s.getFirstUnique());
        //assert s.getFirstUnique() == 3;
        s.add(3);
        System.out.println(s.getFirstUnique());
        //assert s.getFirstUnique() == 4;
	}
}
