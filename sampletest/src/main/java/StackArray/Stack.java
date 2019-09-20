package StackArray;

public class Stack<T> {
	
	private T[] stack;
	private int numOfItems;
	
	public Stack() {
		this.stack = (T[]) new Object[1];
	}
	
	public void push(T newData) {
		
		if(numOfItems == this.stack.length) {
			resize(2*this.stack.length);
		}
		
		this.stack[numOfItems++] = newData;
	}
	
	public T pop() {
		T itemToPop = this.stack[--numOfItems];
		
		if(numOfItems >0 && numOfItems == this.stack.length/4) {
			resize(this.stack.length/2);
		}
		this.stack[numOfItems] = null;
		return itemToPop;
	}
	
	public boolean isEmpty() {
		return numOfItems==0;
	}

	public int getSize() {
		return this.numOfItems;
	}
	
	private void resize(int capacity) {
		T[] stackcopy = (T[]) new Object[capacity];
		
		for (int i=0;i<this.stack.length;i++) {
			stackcopy[i] = this.stack[i];
		}
		this.stack = stackcopy;
		
	}
	

}
