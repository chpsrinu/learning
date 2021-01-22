package learning;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinary {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	//Encodes a tree to a single string.
	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}
	
	private static void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) return;
		sb.append(root.val).append(",");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}
	
	//Decodes your encoded data to tree
	public static TreeNode deserialize(String data) {
		if (data.isEmpty()) return null;
		Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(",")));
		return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static TreeNode deserialize(Queue<String> q, int lower, int upper) {
		if (q.isEmpty()) return null;
		String s = q.peek();
		int val = Integer.parseInt(s);
		if (val<lower || val > upper) return null;
		q.poll();
		TreeNode root = new TreeNode(val);
		root.left = deserialize(q, lower, val);
		root.right = deserialize(q, val, upper);
		return root;
	}
	
	
}
