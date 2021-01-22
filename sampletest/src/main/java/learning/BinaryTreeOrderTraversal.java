package learning;

import java.util.*;

public class BinaryTreeOrderTraversal {

	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode() {}
		      TreeNode(int val) { this.val = val; }
		      TreeNode(int val, TreeNode left, TreeNode right) {
		          this.val = val;
		          this.left = left;
		          this.right = right;
		      }
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> resList = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            resList.add(list);
        }
       return resList;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t9 = new TreeNode(9);
		TreeNode t20 = new TreeNode(20);
		TreeNode t15 = new TreeNode(15);
		TreeNode t7 = new TreeNode(7);
		
		t1.left = t9;
		t1.right = t20;
		t20.left = t15;
		t20.right = t7;
		System.out.println(levelOrder(t1));
	}
}
