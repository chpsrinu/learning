package QueueWithStack;

import java.util.Stack;

public class Queue {

	private Stack<Integer> enqueueStack;
	private Stack<Integer> dequeueStack;
	
	public Queue() {
		this.enqueueStack = new Stack<>();
		this.dequeueStack = new Stack<>();
	}
	
	public void enqueue(int item) {
		this.enqueueStack.push(item);
	}
	
	public int dequeue() {
		if (enqueueStack.isEmpty() && dequeueStack.isEmpty())
			throw new RuntimeException("Stack is empty...");
		
		if (dequeueStack.isEmpty()) {
			while(!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		
		return dequeueStack.pop();
	}
	
	public int dequeueWithRecursive() {
		if(enqueueStack.size() == 1) {
			return enqueueStack.pop();
		}
		int item = enqueueStack.pop();
		int lastDequeueItem = dequeueWithRecursive();
		
		enqueue(item);
		return lastDequeueItem;
	}
}
