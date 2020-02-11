package learning;

import BinarySearchTree.BinarySearchTree;

public class BinaryTreeHeight {

//	class Node {
//		int data;
//		Node left;
//		Node right;
//	}
	
//	public static int height(Node root) {
//		if (root == null) return 1;
//        int leftCount = 0,rightCount=0;
//
//        leftCount += height(root.left);
//        rightCount += height(root.right);
//        return leftCount>rightCount?leftCount:rightCount;
//	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bt = new BinarySearchTree<Integer>();
		bt.insert(3);
		bt.insert(5);
		bt.insert(2);
		bt.insert(1);
		bt.insert(4);
		bt.insert(6);
		bt.insert(7);
		System.out.println(bt.height(bt.getRoot()));
	}
}
