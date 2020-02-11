package learning;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

	double sum;
	int size;
	Queue<Integer> list;
	
	public MovingAverage(int size) {
		this.list = new LinkedList<>();
		this.size = size; 
	}
	
	public double next(int val) {
		sum += val;
		list.offer(val);
		
		if(list.size() <= size) {
			return sum/list.size();
		}
		sum -=list.poll();
		return sum/size;
	}
	
	public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(2);
		System.out.println(ma.next(1));
		System.out.println(ma.next(2));
		System.out.println(ma.next(3));
		System.out.println(ma.next(4));
	}
}
