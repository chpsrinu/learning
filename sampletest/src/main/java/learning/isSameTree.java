package learning;

public class isSameTree {
	
	class TreeNode<T extends Comparable<T>> {
		T val;
		TreeNode left;
		TreeNode right;
		public TreeNode(T val) {
			this.val = val;
		}
	}
	public boolean isSameTreeFn(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		if (p.val != q.val) return false;
		return isSameTreeFn(p.left, q.left) && isSameTreeFn(p.right, q.right);
	}

	
}
