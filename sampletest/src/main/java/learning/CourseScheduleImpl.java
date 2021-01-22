package learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

//https://www.programcreek.com/2014/05/leetcode-course-schedule-java/
public class CourseScheduleImpl {

	public static void main(String[] args) {
		int[][] arr = {{1,0},{0,1}};
		System.out.println(canFinish(2 , arr));
	}
	//solution - 1 BFS
	public static boolean canFinish(int numCourses, int[][] prerequisties) {
		if (prerequisties == null) throw new IllegalArgumentException("Illegal prerequisties array");
		
		int len = prerequisties.length;
		
		if (numCourses == 0 || len == 0) return true;
		
		// counter for num of prerequisites
		int[] pCounter = new int[numCourses];
		for (int i =0;i<len;i++) {
			pCounter[prerequisties[i][0]]++;
		}
		// store courses that have no prerequisties
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i=0;i<numCourses;i++) {
			if(pCounter[i]==0) {
				queue.add(i);
			}
		}
		
		// number of courses that have no prerequisites
		int numNoPre = queue.size();
		
		while(!queue.isEmpty()) {
			int top = queue.remove();
			for (int i=0;i<len;i++) {
				// if a course's prerequisite can be satisfied by a course in queue
				if(prerequisties[i][1] == top) {
					pCounter[prerequisties[i][0]]--;
					if (pCounter[prerequisties[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisties[i][0]);
					}
				}
			}
		}
		return numNoPre == numCourses;
	}
	
	// solution - 1 DFS
	public boolean canFinish2(int numCourses, int[][] prerequisites) {
	    if(prerequisites == null){
	        throw new IllegalArgumentException("illegal prerequisites array");
	    }
	 
	    int len = prerequisites.length;
	 
	    if(numCourses == 0 || len == 0){
	        return true;
	    }
	 
	    //track visited courses
	    int[] visit = new int[numCourses];
	 
	    // use the map to store what courses depend on a course 
	    HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
	    for(int[] a: prerequisites){
	        if(map.containsKey(a[1])){
	            map.get(a[1]).add(a[0]);
	        }else{
	            ArrayList<Integer> l = new ArrayList<Integer>();
	            l.add(a[0]);
	            map.put(a[1], l);
	        }
	    }
	 
	    for(int i=0; i<numCourses; i++){
	        if(!canFinishDFS(map, visit, i))
	            return false;
	    }
	 
	    return true;
	}
	 
	private boolean canFinishDFS(HashMap<Integer,ArrayList<Integer>> map, int[] visit, int i){
	    if(visit[i]==-1) 
	        return false;
	    if(visit[i]==1) 
	        return true;
	 
	    visit[i]=-1;
	    if(map.containsKey(i)){
	        for(int j: map.get(i)){
	            if(!canFinishDFS(map, visit, j)) 
	                return false;
	        }
	    }
	 
	    visit[i]=1;
	 
	    return true;
	}
}
