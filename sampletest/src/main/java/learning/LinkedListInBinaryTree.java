package learning;

//https://leetcode.com/problems/linked-list-in-binary-tree/
public class LinkedListInBinaryTree {

	// Brute DFS Time O(N*min(L,H) Space O(H), N=tree size, H=treeheight, L = list length.
	public boolean isSubPath(ListNode head, TreeNode root) {
		if(head == null) return true;
		if(root == null) return false;
		return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
	}
	
	private boolean dfs(ListNode head, TreeNode root) {
		if (head == null) return true;
		if (root == null) return false;
		return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
	}
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
}
