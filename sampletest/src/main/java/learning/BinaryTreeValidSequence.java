package learning;

public class BinaryTreeValidSequence {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {
			// TODO Auto-generated constructor stub
		}
		
		TreeNode(int val)  {
			this.val = val;
		}
		
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static boolean isValidSeq(TreeNode root, int[] arr) {
		return checkPath(root, arr, 0);
	}
	
	private static boolean checkPath(TreeNode root, int[] arr, int index) {
		if(root == null || index == arr.length) return false;
		
		if(root.left == null && root.right == null && root.val == arr[index] && index == arr.length-1) return true;
		return root.val == arr[index] && (checkPath(root.left, arr, index+1) || checkPath(root.right, arr, index+1));
	}
	
	public static void main(String[] args) {
		int arr[] = {5, 8, 6, 7}; 
		int n = arr.length; 
	    TreeNode root = new TreeNode(5); 
	    root.left = new TreeNode(3); 
	    root.right = new TreeNode(8); 
	    root.left.left = new TreeNode(2); 
	    root.left.right = new TreeNode(4); 
	    root.left.left.left = new TreeNode(1); 
	    root.right.left = new TreeNode(6); 
	    root.right.left.right = new TreeNode(7); 
		
	    System.out.println(isValidSeq(root, arr));
	}
}
