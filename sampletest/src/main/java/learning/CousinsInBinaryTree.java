package learning;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree/
public class CousinsInBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}

	//BFS
	public boolean isCousins(TreeNode root, int A, int B) {
		if(root == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			boolean isAexist = false;
			boolean isBexist = false;
			for(int i=0;i<size;i++) {
				TreeNode cur = queue.poll();
				if (cur.val == A) isAexist = true;
				if (cur.val == B) isBexist = true;
				if (cur.left != null && cur.right != null) {
					if(cur.left.val == A && cur.right.val == B) {
						return false;
					}
					if(cur.left.val == B && cur.right.val == A) {
						return false;
					}
				}
				if(cur.left != null) {
					queue.offer(cur.left);
				}
				if(cur.right != null) {
					queue.offer(cur.right);
				}
			}
			if (isAexist && isBexist) 
				return true;
			else if(isAexist || isBexist)
				return false;
		}
		return false;
	}
	
	//DFS
	public boolean isCousins2(TreeNode root, int x, int y) {
        return findDepth(root,x,1) == findDepth(root,y,1) && !isSibling(root,x,y); 
    }
    
    private boolean isSibling(TreeNode node, int x, int y) {
        if(node == null) return false;
        
        boolean check = false;
        if(node.left != null && node.right != null){
            check = (node.left.val == x && node.right.val == y) ||
                    (node.left.val == y && node.right.val == x);
        }
        return check || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }
    
    private int findDepth(TreeNode node, int val, int height) {
        if(node == null) return 0;
        if(node.val == val) return height;
        
        return findDepth(node.left, val, height + 1) | 
               findDepth(node.right, val, height + 1);
    }
}
