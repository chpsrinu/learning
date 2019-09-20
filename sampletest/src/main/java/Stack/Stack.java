package Stack;

public class Stack<T extends Comparable<T>> {
	
	private Node<T> root;
	private int count;
	
	//O(N)
	public void push(T data) {
		++count;
		
		if(this.root == null) {
			this.root = new Node<>(data);
		} else {
			Node node = new Node<>(data);
			node.setNextNode(root);
			this.root = node;
		}
	}
	
	public T pop() {
		
		T itemToPop = this.root.getData();
		this.root = this.root.getNextNode();
		this.count--;
		return itemToPop;
	}
	
	public T peek() {
		return this.root.getData();
	}
	
	public int size() {
		return this.count;
	}
	
	public boolean isEmpty() {
		return this.root ==null;
	}
}
