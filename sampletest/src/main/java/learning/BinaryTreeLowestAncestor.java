package learning;

public class BinaryTreeLowestAncestor {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}
	//recursive
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//value of current node or parent node
		int parentVal = root.val;
		//value of p
		int pVal = p.val;
		int qVal = q.val;
		
		if (pVal > parentVal && qVal > parentVal) {
			return lowestCommonAncestor(root.right, p, q);
		}else if(pVal < parentVal && qVal < parentVal) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}
	//iterative
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q ) {
		int parentVal = root.val;
		int pVal = p.val;
		int qVal = q.val;
		
		while(root != null) {
			if (pVal > parentVal && qVal > parentVal) {
				root = root.right;
			} else if(pVal < parentVal && qVal < parentVal) {
				root = root.left;
			} else {
				return root;
			}
		}
		return null;
	}
}
