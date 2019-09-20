package BinarySearchTree;

public class TreeCompareHelper<T extends Comparable<T>> {

	public boolean CompareTrees(Node<T> node1, Node<T> node2) {
		
		// we have to check the base case
		if (node1 == null || node2 == null) return node1==node2;
		
		//if the value within the nodes are not the same we return false
		if(node1.getData().compareTo(node2.getData()) != 0) return false;
		
		return CompareTrees(node1.getLeftChild(), node2.getLeftChild()) && CompareTrees(node1.getRightChild(), node2.getRightChild());
	}
}
