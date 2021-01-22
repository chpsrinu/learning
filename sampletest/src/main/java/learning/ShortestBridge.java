package learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/shortest-bridge/solution/
public class ShortestBridge {
	
	public static void main(String[] args) {
		int[][] A = {{0,1},{1,0}};
		int[][] A2 = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
		int[][] A3 = {{0,1,0},{0,0,0},{0,0,1}};
		System.out.println(shortestBridge(A2));
	}
	
	static int[][] DIR = new int[][] {{1, 0}, {-1, 0}, {0 , 1}, {0 , -1}};
    public static int shortestBridge(int[][] A) {
        
        //Step 1: Identify one of the islands using dfs and assign 2 to it.
        boolean identified  = false;
        int n = A.length;
        for(int i = 0; i < n && !identified; i++) {
            for(int j = 0; j < n; j++){
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    identified = true;
                    break;
                }
            }
        }
        
        // Step 2: Add all points of island 1 to Queue (initialize BFS)
        Queue<int[]> queue = new LinkedList<int[]>();
        Set<String> visited = new HashSet<String>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if (A[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited.add(i + "," + j);
                }
            }
        }
        
        // Step 3: BFS to find island 2
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1; i <= size; i++){
                int[] current = queue.poll();
                for(int j = 0; j < DIR.length; j++){
                    int x = current[0] + DIR[j][0];
                    int y = current[1] + DIR[j][1];
                    if(x < 0 || x >= n || y < 0 || y >= n || visited.contains(x + "," + y)){
                        continue;
                    }
                    if (A[x][y] == 2) { // Found island 2
                        return steps;
                    }
                    queue.add(new int[]{x, y});
                    visited.add(x + "," + y);
                }
            }
            steps++;
        }
        return steps;
    }
    
    public static void dfs(int[][] A, int i, int j) {
        if (i < 0 || i == A.length || j < 0 || j == A.length || A[i][j] != 1) 
            return;
        A[i][j] = 2;
        dfs(A, i + 1,j);
        dfs(A, i - 1, j);
        dfs(A, i, j + 1);
        dfs(A, i, j - 1);
    }
}
 

