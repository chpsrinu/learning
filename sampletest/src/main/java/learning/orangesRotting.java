package learning;

import java.util.LinkedList;
import java.util.Queue;
//BFS
public class orangesRotting {
	public static void main(String[] args) {
		int[][] grid = {
				{2,1,1},
				{1,1,0},
				{0,1,1}
		};
		System.out.println(orangesRotting(grid));
	}

	//store the position of rotten orange
	static class Position {
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int orangesRotting(int[][] grid) {
		Queue<Position> q = new LinkedList<>();
		int total = 0, rotten = 0, time = 0;
		
		//traverse the grid, offer position of rotten orange into queue, and count the total num of orange
		for(int i =0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if (grid[i][j] == 2 || grid[i][j] == 1) total++;
				if (grid[i][j] == 2) q.offer(new Position(i,j));
			}
		}
		
		//if there is no orange, return 0;
		if(total == 0) return 0;
		
		while(!q.isEmpty() && rotten < total) {
			//size is the num of rotten oranges of the last round
			int size = q.size();
			
			// count the num of rotten oranges, if it equals to total num, return time;
			rotten += size;
			if(rotten == total) return time;
			
			//every round, time++
			time++;
			
			// continue to dequeue utnile all rotten oranges of last round are removed from the queue
			for (int i=0;i<size;i++) {
				Position p = q.peek();
				
				// check the cell in the left/right/top/down of the rotten orange, if it is a fresh orange, enqueue it.
				if (p.x+1>0 && p.x+1 <grid.length && grid[p.x+1][p.y] ==1 ) {
					grid[p.x+1][p.y] = 2;
					q.offer(new Position(p.x+1, p.y));
				}
				if (p.x-1>0 && p.x-1 <grid.length && grid[p.x-1][p.y] ==1 ) {
					grid[p.x-1][p.y] = 2;
					q.offer(new Position(p.x-1, p.y));
				}
				if (p.y+1>0 && p.y+1 <grid.length && grid[p.x][p.y+1] ==1 ) {
					grid[p.x][p.y+1] = 2;
					q.offer(new Position(p.x, p.y+1));
				}
				if (p.y-1>0 && p.y-1 <grid.length && grid[p.x][p.y-1] ==1 ) {
					grid[p.x][p.y-1] = 2;
					q.offer(new Position(p.x, p.y-1));
				}
				q.poll();
			}
		}
		return -1;
	}
}
//DFS
class Solution2 {
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
            }
        }
        
        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }
        
        return minutes - 2;
    }
    
    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if(i < 0 || i >= grid.length /* out of bounds */
          || j < 0 || j >= grid[0].length /* out of bounds */
          || grid[i][j] == 0 /* empty cell */
          || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
          ) return;
        else {
            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }
}
