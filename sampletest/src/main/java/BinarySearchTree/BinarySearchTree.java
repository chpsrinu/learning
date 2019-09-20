package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
	
	private Node<T> root;
	
	public void insert(T data) {
		if(this.root == null) {
			this.root = new Node(data);
		} else {
			insertNode(data, this.root);
		}
	}

	@Override
	public void traversal() {
		if (this.root != null) {
			inOrderTraversal(root);
		}
	}

	
	private void inOrderTraversal(Node<T> node) {
		if(node.getLeftChild() != null) 
			inOrderTraversal(node.getLeftChild());
		
		System.out.print(node+ " ----> ");
		
		if (node.getRightChild() != null)
			inOrderTraversal(node.getRightChild());
		
	}

	public void insertNode(T newData, Node<T> node) {
		if(newData.compareTo(node.getData())  < 0) {
			if(node.getLeftChild() != null) {
				insertNode(newData, node.getLeftChild());
			} else {
				node.setLeftChild(new Node<>(newData));
			}
		} else {
			if (node.getRightChild() != null) {
				insertNode(newData, node.getRightChild());
			} else {
				node.setRightChild(new Node<>(newData));
			}
		}
	}

	@Override
	public void delete(T data) {

		if (root != null) 
		
			root = delete(root, data);
	}

	private Node<T> delete(Node<T> node, T data) {
		if (node == null) return node;
		
		if (data.compareTo(node.getData()) < 0) {
			node.setLeftChild(delete(node.getLeftChild(), data));
		} else if(data.compareTo(node.getData()) > 0) {
			node.setRightChild(delete(node.getRightChild(), data));
		} else {
			if( node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("removing a leaf node");
				return null;
			}
			
			if (node.getLeftChild() == null) {
				System.out.println("removing the right child");
				Node tempNode = node.getRightChild();
				node = null;
				return tempNode;
			} else if (node.getRightChild() == null) {
				System.out.println("remvoing the left child");
				Node tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}
			
			// this is the case with two child case
			System.out.println("removing item with two children");
			Node<T> tempNode = getPredecessor(node.getLeftChild());
			
			node.setData(tempNode.getData());
			node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
			
		}
		return node;
		 
	}

	private Node getPredecessor(Node<T> leftChild) {
		if( leftChild.getRightChild() != null) {
			return getPredecessor(leftChild.getRightChild());
		}
		
		return leftChild;
	}

	public T getMax() {
		if (root == null) return null;
		
		return getMax(root);
	}
	
	private T getMax(Node<T> n) {
		
		if(n.getRightChild() != null) {
			return getMax(n.getRightChild());
		} 
		
		return n.getData();
	}

	public T getMin() {
		if (root == null) return null;
		return getMin(this.root);
	}
	
	
	private T getMin(Node<T> n) {
		if (n.getLeftChild() != null) {
			return getMin(n.getLeftChild());
		}
		return n.getData();
	}

	@Override
	public Node<T> getRoot() {
		return this.root;
	}

	@Override
	public Node<T> getKSmallest(Node<T> node, int k) {
		
		//number of nodes in the left subtree
		//+1 because we count the root node of the subtree as well
		int n = treeSize(node.getLeftChild())+1;
		
		if(n == k) return node;
		
		if (n < k) return getKSmallest(node.getRightChild(), k-n);
		
		if (n > k) return getKSmallest(node.getLeftChild(), k);
		return null;
	}

	// calculate the size of the subtree with root node 'node'
	private int treeSize(Node<T> node) {
		//this is base case
		if(node==null) return 0;
		
		return treeSize(node.getLeftChild())+treeSize(node.getRightChild())+1;
	}

	@Override
	public int getAgesSum() {
		return getAges(this.root);
	}
	
	private int getAges(Node<T> node) {
		System.out.println("Considering node " + node);
		
		//we have to reinitialize the variables (sum in the parent's node value so the sum of the subtree so far)
		int sum =0;
		int leftSum = 0;
		int rightSum = 0;
		
		//null node have sum value 0 
		if (node == null) return 0;
		
		leftSum = getAges(node.getLeftChild());
		rightSum = getAges(node.getRightChild());
		
		sum = ((Person)node.getData()).getAge()+leftSum+rightSum;
		return sum;
	}

}
