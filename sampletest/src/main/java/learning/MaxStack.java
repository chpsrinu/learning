package learning;

import java.util.Stack;

public class MaxStack {

	static class StackWithMax {
		static Stack<Integer> mainStack = new Stack<>();
		static Stack<Integer> trackStack = new Stack<>();
		
		static void push(int x) {
			mainStack.push(x);
			if(mainStack.size() == 1){
				trackStack.push(x);
				return;
			}
			if (x>trackStack.peek()) {
				trackStack.push(x);
			} else {
				trackStack.push(trackStack.peek());
			}
		}
		
		static int getMax() {
			return trackStack.peek();
		}
		
		static void pop() {
			mainStack.pop();
			trackStack.pop();
		}
	}
	public static void main(String[] args) {
		StackWithMax sm = new StackWithMax();
		sm.push(20);
		sm.push(1);
		sm.push(55);
		sm.push(10);
		
		System.out.println(sm.getMax());
		sm.pop();
	}
}
