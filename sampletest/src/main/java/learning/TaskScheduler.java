package learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = {'A','A','A','B','C'};
		System.out.println(leastInterval2(tasks, 3));
	}
	public static int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c : tasks) {
			map[c-'A']++;
		}
		Arrays.sort(map);
		int time = 0;
		while (map[25] >0) {
			int i = 0;
			while (i<= n) {
				if(map[25] == 0)
					break;
				if(i<26 && map[25-i] >0)
					map[25-i]--;
				time++;
				i++;
			}
			Arrays.sort(map);
		}
		return time;
	}
	
	public static int leastInterval2(char[] tasks, int n) {
		int[] map = new int[26];
		for (char c :tasks)
			map[c-'A']++;
		PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
		for (int f : map)
			if(f>0)
				queue.add(f);
		int time = 0;
		while(!queue.isEmpty()) {
			int i =0;
			List<Integer> temp = new ArrayList<Integer>();
			while(i<=n) {
				if (!queue.isEmpty()) {
					if (queue.peek() > 1)
						temp.add(queue.poll()-1);
					else
						queue.poll();
				}
				time++;
				if (queue.isEmpty() && temp.size() == 0)
					break;
				i++;
			}
			for (int l : temp)
				queue.add(l);
		}
		return time;
	}
}
