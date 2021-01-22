package learning;

public class CircularQueue {

	private int[] arr;
	private int start;
	private int end;
	private int size;
	
	public CircularQueue(int capacity) {
		arr = new int[capacity];
		start = -1;
		end = -1;
	}
	
	public boolean enQueue(int value) {
		if(isFull()) return false;
		if(++end >= arr.length) end = 0;
		arr[end] = value;
		if(size == 0) start = end;
		size++;
		return true;
	}
	
	public boolean deQueue() {
		if(isEmpty()) return false;
		arr[start++] = -1;
		if(start>=arr.length) start =0;
		size--;
		if(size==0) {
			start = -1;
			end = -1;
		}
		return true;
	}
	
	/** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return arr[start];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;
        return arr[end];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}
