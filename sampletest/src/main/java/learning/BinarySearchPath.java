package learning;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchPath {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) return res;
		dfs(root, res, "");
		return res;
	}

	private void dfs(TreeNode root, List<String> res, String accum) {
		if (root == null) return;
		accum += (accum.length() == 0? "":"->")+root.val;
		if (root.left == null && root.right == null) {
			res.add(accum);
			return;
		}
		dfs(root.left, res, accum);
		dfs(root.right, res, accum);
	}
}
