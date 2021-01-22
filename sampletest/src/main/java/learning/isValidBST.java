package learning;

import java.util.Stack;

public class isValidBST {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static boolean isvalidBST(TreeNode root) {
		return helper(root, null, null);
	}
	
	private static boolean helper(TreeNode root, Integer lower, Integer upper) {
		if (root == null) return true;
		
		int val = root.val;
		if (lower!=null && val <= lower) return false;
		if (upper != null && val >= upper) return false;
		
		if (!helper(root.right, val, upper)) return false;
		if (!helper(root.left, lower, val)) return false;
		return true;
	}
	
	public static boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		int inorder = Integer.MIN_VALUE;
		
		while( !stack.isEmpty() || root != null) {
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			
			if(root.val <= inorder) return false;
			inorder = root.val;
			root = root.right;
		}
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(2);
		node.left.left=new TreeNode(1);
		node.left.right = new TreeNode(6);
		node.right = new TreeNode(5);
		System.out.println(isValidBST(node));
	}
	
}
