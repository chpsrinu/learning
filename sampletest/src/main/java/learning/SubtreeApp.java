package learning;

import learning.Subtree.TreeNode;

public class SubtreeApp {

	public static void main(String[] args) {
		Subtree st = new Subtree();
		TreeNode node = st.new TreeNode(3);
		node.left = st.new TreeNode(4);
		node.left.left = st.new TreeNode(1);
		node.left.right = st.new TreeNode(2);
		node.right = st.new TreeNode(5);
		
		TreeNode node2 = st.new TreeNode(4);
		node2.left = st.new TreeNode(1);
		node2.right = st.new TreeNode(2);
		
		System.out.println(st.isSubtree(node, node2));
		
	}
}
