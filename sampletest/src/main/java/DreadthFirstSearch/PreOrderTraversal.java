package DreadthFirstSearch;

public class PreOrderTraversal {
//https://www.java67.com/2016/07/how-to-implement-preorder-traversal-of-binary-tree-in-java.html
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		BinaryTree.TreeNode root = new BinaryTree.TreeNode("A");
		bt.root=root;
		bt.root.left = new BinaryTree.TreeNode("B");
		bt.root.left.left = new BinaryTree.TreeNode("C");
		
		bt.root.left.right = new BinaryTree.TreeNode("D");
		bt.root.right = new BinaryTree.TreeNode("E");
		bt.root.right.right = new BinaryTree.TreeNode("F");
		
		System.out.println("printing nodes of a binary tree in preOrder using recursion");
		bt.preOrder(bt.root);
	}
}

class BinaryTree {
	static class TreeNode {
		String data;
		TreeNode left, right;
		
		TreeNode(String value) {
			this.data = value;
			left = right = null;
		}
		boolean isLeaf() {
			return left ==null?right==null : false;
		}
	}
	
	TreeNode root;
	
	public void preOrder() {
		preOrder(root);
	}
	
	public void preOrder(TreeNode node) {
		if (node == null) {
			return;
		}
		System.out.printf("%s ", node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
}
