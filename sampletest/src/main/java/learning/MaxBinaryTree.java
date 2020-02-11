package learning;

public class MaxBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static TreeNode constructMaxBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length);
	}
	
	private static TreeNode construct(int[] nums, int l,int r) {
		if (l==r) return null;
		
		int max_i = max(nums, l, r);
		TreeNode root = new TreeNode(nums[max_i]);
		root.left = construct(nums, l, max_i);
		root.right = construct(nums, max_i+1, r);
		return root;
	}
	
	private static int max(int[] nums, int l, int r) {
		int max_i = l;
		for (int i =l;i<r;i++) {
			if (nums[max_i] < nums[i]) {
				max_i = i;
			}
		}
		return max_i;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,6,0,5};
		TreeNode root = constructMaxBinaryTree(nums);
		print(root);
	}
	
	private static void print(TreeNode root) {
		System.out.println(root.val);
		if (root.left!=null) {
			print(root.left);
		}
		if (root.right != null) {
			print(root.right);
		}
	}
}
