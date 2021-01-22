package learning;

public class RingBuffer {
	public Object[] elements = null;
	private int capacity = 0;
	private int writePro = 0;
	private int readPro = 0;
	private boolean flipped = false;
	
	public RingBuffer(int capacity) {
		this.capacity = capacity;
		elements = new Object[capacity];
	}
	
	public void reset() {
		this.writePro = 0;
		this.readPro = 0;
		this.flipped = false;
	}
	
	public int available() {
		if(!flipped)
			return writePro-readPro;
		return capacity-readPro+writePro;
	}
	
	public int remainingCapacity() {
		if(!flipped)
			return capacity-writePro;
		return readPro-writePro;
	}
	
	public boolean put(Object element) {
		if(!flipped) {
			if(writePro==capacity) {
				writePro=0;
				flipped=true;
				
				if(writePro<readPro) {
					elements[writePro++]=element;
					return true;
				} else {
					return false;
				}
			} else {
				elements[writePro++] = element;
				return true;
			}
		} else {
			if(writePro<readPro) {
				elements[writePro++]=element;
				return true;
			} else {
				return false;
			}
		}
	}
	
	public Object take() {
		if(!flipped) {
			if(readPro<writePro) {
				return elements[readPro++];
			} else {
				return null;
			}
		} else {
			if(readPro == capacity) {
				readPro =0;
				flipped=false;
				
				if(readPro<writePro) {
					return elements[readPro++];
				} else{
					return null;
				}
			} else {
				return elements[readPro++];
			}
		}
	}
	
	public static void main(String[] args) {
		RingBuffer rb = new RingBuffer(4);
		rb.put(1);
		rb.put(2);
		rb.put(3);
		rb.put(4);
		rb.put(5);
		System.out.println(rb.take());
	}
}
