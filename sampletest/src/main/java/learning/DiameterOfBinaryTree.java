package learning;

public class DiameterOfBinaryTree {

	static class Node {
		int val;
		Node left;
		Node right;
		public Node(int val) {
			this.val = val;
		}
	}
	static int ans;
	public static int diameterOfBinaryTree(Node root) {
		ans = 1;
		dfs(root);
		return ans-1;
	}
	
	public static int dfs(Node node) {
		if(node == null) return 0;
		int L = dfs(node.left);
		int R = dfs(node.right);
		ans = Math.max(ans, L+R+1);
		return Math.max(L, R)+1;
	}
	
	public static void main(String[] args) {
		Node node = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node.left = node2;
		node.left.left = node4;
		node.left.right = node5;
		node.right = node3;
		System.out.println(diameterOfBinaryTree(node));
		}
	
}
