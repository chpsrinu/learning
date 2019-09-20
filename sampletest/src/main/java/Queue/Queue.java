package Queue;

public class Queue<T extends Comparable<T>> {

	private Node<T> firstNode;
	private Node<T> lastNode;
	private int counter;
	
	public Queue() {
		
	}
	
	public boolean isEmpty() {
		return this.firstNode == null;
	}
	
	public int size() {
		return this.counter;
	}
	
	public void enqueue(T data) {
		this.counter++;
		
		Node<T> oldLastNode = this.lastNode;
		this.lastNode = new Node<>(data);
		this.lastNode.setNextNode(null);
		
		if(isEmpty()) {
			this.firstNode = this.lastNode;
		} else {
			oldLastNode.setNextNode(this.lastNode);
		}
	}
	
	public T dequeue() {
		this.counter--;
		
		T dataToDequeue = this.firstNode.getData();
		this.firstNode = this.firstNode.getNextNode();
		
		if(isEmpty()) {
			this.lastNode = null;
		}
		return dataToDequeue;
	}
}
