package learning;

public class LinkedListSortList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(){}
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public static ListNode sortList(ListNode head) {
		if (head ==null || head.next==null) return head;
		ListNode mid = getMid(head);
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		return merge(left, right);
	}

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummyHead = new ListNode();
		ListNode tail = dummyHead;
		while (left != null && right != null) {
			if (left.val<right.val) {
				tail.next=left;
				left = left.next;
				tail = tail.next;
			} else {
				tail.next = right;
				right = right.next;
				tail = tail.next;
			}
		}
		tail.next = (left != null) ? left:right;
		return dummyHead.next;
	}

	private static ListNode getMid(ListNode head) {
		ListNode midPrev = null;
		while (head!= null && head.next!=null) {
			midPrev = (midPrev==null)?head:midPrev.next;
			head=head.next.next;
		}
		ListNode mid = midPrev.next;
		midPrev.next = null;
		return mid;
	}
	
	public static void main(String[] args) {
		ListNode list = new ListNode(10);
		list.next = new ListNode(1);
		list.next.next = new ListNode(60);
		list.next.next.next = new ListNode(30);
		list.next.next.next.next = new ListNode(5);
		printList(list);
		System.out.println("/n");
		printList(sortList(list));
	}
	private static void printList(ListNode root) {
		while(root!=null){
			System.out.print(root.val+"->");
			root = root.next;
		}
	}
}
