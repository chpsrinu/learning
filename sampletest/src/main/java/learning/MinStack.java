package learning;

import java.util.Stack;

public class MinStack {
	Stack<Integer> minStack;
	Stack<Integer> mainStack;
	
	public MinStack() {
		minStack = new Stack<>();
		mainStack = new Stack<>();
	}
	
	public void push(int val) {
		mainStack.push(val);
		if(minStack.isEmpty()) {
			minStack.push(val);
		}else {
			minStack.push(Math.min(minStack.peek(), val));
		}
	}
	
	public int pop() {
		if(mainStack.isEmpty()) return 0;
		
		int val = mainStack.pop();
		if(val == minStack.peek())
			minStack.pop();
		return val;
	}
	
	public int getMin() {
		return minStack.peek();
	}
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(20);
		stack.push(1);
		stack.push(55);
		System.out.println(stack.getMin());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.getMin());
	}

}
