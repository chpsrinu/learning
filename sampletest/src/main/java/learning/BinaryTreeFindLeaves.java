package learning;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFindLeaves {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val=x;
		}
	}
	
	public static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		
		if (root == null) {
			return ans;
		}
		
		findLeavesHelper(root, ans);
		return ans;
	}
	
	private static int findLeavesHelper(TreeNode root, List<List<Integer>> ans) {
		if (root==null) {
			return -1;
		}
		int left = findLeavesHelper(root.left, ans);
		int right = findLeavesHelper(root.right, ans);
		
		int depth = Math.max(left, right)+1;
		
		if(depth == ans.size()) {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			ans.add(list);
		} else {
			List<Integer> list = ans.get(depth);
			list.add(root.val);
		}
		return depth;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left=new TreeNode(2);
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.right=new TreeNode(3);
		System.out.println(findLeaves(root));
	}
}
