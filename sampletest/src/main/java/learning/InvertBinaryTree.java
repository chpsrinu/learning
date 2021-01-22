package learning;

public class InvertBinaryTree {
	
	/**
	 * 
	 *   4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	 *
	 */

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}
	
	public static TreeNode traverse(TreeNode root) {
		if(root == null) return null;
		
		if(root.left != null) traverse(root.left);
		System.out.print(root.val);
		if(root.right != null) traverse(root.right);
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.left.left = new TreeNode(1);
		traverse(root);
		System.out.println();
		invertTree(root);
		traverse(root);
	}
}
