package learning;
//https://www.programcreek.com/2014/05/leetcode-inorder-successor-in-bst-java/
public class InorderSuccessorBinarySearchTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) return null;
		
		TreeNode next = null;
		TreeNode c = root;
		while(c!=null && c.val!=p.val) {
			if (c.val > p.val) {
				next = c;
				c = c.left;
			} else {
				c = c.right;
			}
		}
		
		if (c==null) return null;
		if(c.right==null) return next;
		
		c = c.right;
		while(c.left!= null) 
			c = c.left;
		return c;
	}
	
	//https://www.programcreek.com/2013/02/leetcode-inorder-successor-in-bst-ii-java/
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	}
	
	public Node inorderSuccessorII(Node x) {
		Node result = null;
		
		//case 1:right child is not null -->go down to get the next
		Node p = x.right;
		while(p!=null) {
			result = p;
			p =p.left;
		}
		
		if(result != null) return result;
		
		//case 2: right child is null -> go up to parent, until the node is a left child, return the parent
		p =x;
		while(p!=null){
			if(p.parent!=null && p.parent.left==p) {
				return p.parent;
			}
			p=p.parent;
		}
		return null;
	}
}
