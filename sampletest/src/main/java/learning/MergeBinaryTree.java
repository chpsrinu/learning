package learning;

import java.util.ArrayList;
import java.util.List;

public class MergeBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> l = new ArrayList<>();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		inorder(l1, root1);
		inorder(l2, root2);
		sort(l, l1, l2);
		return l;
	}

	private static List<Integer> sort(List<Integer> l, List<Integer> l1, List<Integer> l2) {
		int i=0,j=0;
		while(i<l1.size() && j<l2.size()) {
			if (l1.get(i) < l2.get(j)) {
				l.add(l1.get(i++));
			} else {
				l.add(l2.get(j++));
			} 
				
		}
		while(i<l1.size()) l.add(l1.get(i++));
		while(j<l2.size()) l.add(l2.get(j++));
		return l;
	}

	public static void inorder(List<Integer> l1, TreeNode root) {
		if (root == null) return ;
		
		inorder(l1, root.left);
		l1.add(root.val);
		inorder(l1, root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(4);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(0);
		root2.right = new TreeNode(3);
		System.out.println(getAllElements(root1, root2));
//		TreeNode root = new TreeNode(7);
//		root.left = new TreeNode(3);
//		root.right = new TreeNode(12);
//		root.left.left = new TreeNode(1);
//		root.left.left.left = new TreeNode(0);
//		root.left.right = new TreeNode(6);
//		root.left.left.right = new TreeNode(2);
//		root.right.left = new TreeNode(9);
//		root.right.right = new TreeNode(13);
//		List<Integer> l1 = new ArrayList<Integer>();
//		traverseTree(l1, root);
//		System.out.println(l1);
//		for (Integer i: l1) {
//			System.out.println(i);
//		}
	}
}
