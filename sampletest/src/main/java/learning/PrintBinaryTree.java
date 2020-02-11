package learning;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public class PrintBinrayTree {
		public List<List<String>> printTree(TreeNode root) {
	        int height = getHeight(root);
	        String[][] res = new String[height][(1<<height)-1];
	        for (String[] arr: res)
	            java.util.Arrays.fill(arr,"");
	        List<List<String>> ans = new ArrayList<>();
	        fill(res, root, 0,0,res[0].length);
	        for(String[] arr:res)
	            ans.add(java.util.Arrays.asList(arr));
	        return ans;
	    }
	    
	    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
	        if (root==null)
	            return;
	        res[i][(l+r)/2] = ""+ root.val;
	        fill(res, root.left, i+1, l, (l+r)/2);
	        fill(res, root.right, i+1, (l+r+1)/2, r);
	    }
	    
	    public int getHeight(TreeNode node) {
	        if (node==null)
	            return 0;
	        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	    }
	}
}
