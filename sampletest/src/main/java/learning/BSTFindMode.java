package learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BSTFindMode {
	 
	static class TreeNode {
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
	 
	static Integer prev = null;
    static int count = 1;
    static int max = 0;
    
	    public static int[] findMode(TreeNode root) {
	    	if (root == null) return new int[0];
	        
	        List<Integer> list = new ArrayList<>();
	        traverse(root, list);
	        
	        int[] res = new int[list.size()];
	        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
	        return res;
	    }
	    
	    private static void traverse(TreeNode root, List<Integer> list) {
	        if (root == null) return;
	        traverse(root.left, list);
	        if (prev != null) {
	            if (root.val == prev)
	                count++;
	            else
	                count = 1;
	        }
	        if (count > max) {
	            max = count;
	            list.clear();
	            list.add(root.val);
	        } else if (count == max) {
	            list.add(root.val);
	        }
	        prev = root.val;
	        traverse(root.right, list);
	    }
	
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.right=new TreeNode(2);
		node.right.left = new TreeNode(2);
		System.out.println(findMode(node));
	}
}
