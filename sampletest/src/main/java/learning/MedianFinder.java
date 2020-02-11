package learning;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;
	
	public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	}
	
	public void addNum(int num) {
		if(num > findMedian()) {
			minHeap.offer(num);
		} else {
			maxHeap.offer(num);
		}
		if(maxHeap.size()-minHeap.size()>1) {
			minHeap.offer(maxHeap.poll());
		} else if(maxHeap.size()<minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
//		minHeap.offer(num);
//		maxHeap.offer(minHeap.poll());
//		
//		if (minHeap.size()<maxHeap.size()) {
//			minHeap.offer(maxHeap.poll());
//		}
	}
	
	public double findMedian() {
		if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;
		if(maxHeap.size() == minHeap.size()) return ((double)maxHeap.peek() + (double)minHeap.peek())/2.0;
		else return maxHeap.peek();
//		if (minHeap.size() > maxHeap.size()) {
//			return minHeap.peek();
//		} else {
//			return (minHeap.peek()+maxHeap.peek())/2.0;
//		}
	}
	
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
	}
}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++
//public class FindMedianOf2SortedArrays {
//	public static void main(String[] args) {
//		int[] a = {5,71,100,170}; //5,17,35,71,100,102.103,170 (Median is (71+100) / 2 ==> 85.5
//		int[] b = {17,35,102,103};
//		System.out.println(findMedianSortedArrays(a,b));
//	}
//	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        Queue<Integer> minHeap = new PriorityQueue<>();
//        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//        
//        int i = 0, j = 0; 
//        for(; i < nums1.length && j < nums2.length; ) {
//            int nextNum = 0;
//            if(nums1[i] > nums2[j]) { nextNum = nums2[j]; j++; }
//            else { nextNum = nums1[i]; i++; }
//            addAndAdjustHeaps(minHeap, maxHeap, nextNum);
//        }
//        while(i < nums1.length) {
//        		addAndAdjustHeaps(minHeap, maxHeap, nums1[i]);
//        		i++;
//        }
//        while(j < nums2.length) {
//	    		addAndAdjustHeaps(minHeap, maxHeap, nums2[j]);
//	    		j++;
//	    }
//        
//        double median = 0;
//        if(minHeap.size() == maxHeap.size()) {
//            median = (minHeap.peek() + maxHeap.peek()) / 2.0;
//        }else if(minHeap.size() > maxHeap.size()) {
//            median = minHeap.peek();
//        }else {
//            median = maxHeap.peek();
//        }
//        return median;
//    }
//	
//	private static void addAndAdjustHeaps(Queue<Integer> minHeap, Queue<Integer> maxHeap, int nextNum) {
//		minHeap.add(nextNum);
//		while(!maxHeap.isEmpty() && maxHeap.peek() < minHeap.peek()) {
//            minHeap.add(maxHeap.poll());
//        } 
//        //Now adjust their sizes to |min size - max size| == 1
//        while(Math.abs(minHeap.size() - maxHeap.size()) > 1) {
//            maxHeap.add(minHeap.poll());
//        }
//	}
//}
