package learning;

import java.util.Stack;

public class QueueWithStack {

	private Stack<Integer> enqueue;
	private Stack<Integer> dequeue;
	
	public QueueWithStack() {
		this.enqueue = new Stack<>();
		this.dequeue = new Stack<>();
	}
	
	public void enqueue (int val) {
		this.enqueue.push(val);
	}
	
	public int dequeue() {
		if (enqueue.isEmpty() && dequeue.isEmpty()) throw new RuntimeException("Stack is empty...");
		
		if (dequeue.isEmpty()) {
			while(!enqueue.isEmpty()) {
				dequeue.push(enqueue.pop());
			}
		}
		return dequeue.pop();
	}
	
	public int dequeue2() {
		if(enqueue.size() == 1) return enqueue.pop();
		
		int item = enqueue.pop();
		int lastItem = dequeue2();
		
		enqueue.push(item);
		return lastItem;
	}
	
	public static void main(String[] args) {
		QueueWithStack queue = new QueueWithStack();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.dequeue2());
		queue.enqueue(4);
		System.out.println(queue.dequeue2());
		System.out.println(queue.dequeue2());
		System.out.println(queue.dequeue2());
	}
}
