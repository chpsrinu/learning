package learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom {

	static class Interval {
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start= start;
			this.end=end;
		}
	}
	//meeting room 1
	public boolean canAttendMeetings(Interval[] intervals) {
	    Arrays.sort(intervals, new Comparator<Interval>(){
	        public int compare(Interval a, Interval b){
	            return a.start-b.start;
	        }
	    });
	 
	    for(int i=0; i<intervals.length-1; i++){
	        if(intervals[i].end>intervals[i+1].start){
	            return false;
	        }
	    }
	 
	    return true;
	}
	//meeting room II
	public static int findMinNoOfMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length==0) return 0;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start -i2.start;
			}
		});
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(intervals[0].end);
		for (int i=1;i<intervals.length;i++) {
			if (queue.peek() <= intervals[i].start) queue.poll();
			queue.add(intervals[i].end);
		}
		return queue.size();
	}
}
