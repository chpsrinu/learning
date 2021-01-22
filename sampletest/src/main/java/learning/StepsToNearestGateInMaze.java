package learning;

import java.util.LinkedList;
import java.util.Queue;

public class StepsToNearestGateInMaze {

	class MazeGraphNode {
		int i;
		int j;
		int depth;
		public MazeGraphNode(int i, int j, int depth) {
			this.i=i;
			this.j=j;
			this.depth=depth;		
		}
	}
	
	public void stepsToNearestGate(char[][] maze) {
		int m = maze.length;
		int n = maze[0].length;
		
		for (int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(maze[i][j]=='G') {
					bfs(maze, i, j);
				}
			}
		}
	}

	private void bfs(char[][] maze, int gateRowIndex, int gateColumnIndex) {
		int m = maze.length;
		int n = maze[0].length;
		boolean[][] visited = new boolean[m][n];
		
		Queue<MazeGraphNode> q = new LinkedList<StepsToNearestGateInMaze.MazeGraphNode>();
		q.add(new MazeGraphNode(gateRowIndex, gateColumnIndex, 0));
		
		while(!q.isEmpty()) {
			MazeGraphNode node = q.remove();
			int i = node.i;
			int j = node.j;
			visited[i][j] = true;
			
			//node on left
			if(j-1>0 && j-1<n && visited[i][j-1] == false) {
				MazeGraphNode topNode = getExistingDepthIfAny(maze, i, j-1, node);
				if(topNode!= null) {
					q.add(topNode);
				}
			}
			
			//node on top
			if(i-1>0 && i-1<m && visited[i-1][j] == false) {
				MazeGraphNode topNode = getExistingDepthIfAny(maze, i-1, j, node);
				if(topNode!= null) {
					q.add(topNode);
				}
			}
			
			//node on right
			if(j+1>0 && j+1<n && visited[i][j+1] == false) {
				MazeGraphNode topNode = getExistingDepthIfAny(maze, i, j+1, node);
				if(topNode!= null) {
					q.add(topNode);
				}
			}
			
			//node on bottom
			if(i+1>0 && i+1<m && visited[i+1][j] == false) {
				MazeGraphNode topNode = getExistingDepthIfAny(maze, i+1, j, node);
				if(topNode!= null) {
					q.add(topNode);
				}
			}
			
		}
	}

	private MazeGraphNode getExistingDepthIfAny(char[][] maze, int i, int j, MazeGraphNode parent) {
		if(maze[i][j] == 'G' || maze[i][j]=='W') return null;
		if(maze[i][j] == '_') {
			maze[i][j] = (char)('0'+parent.depth+1);
			return new MazeGraphNode(i, j, parent.depth+1);
		}
		int updateDepth = Math.min(maze[i][j]-'0', parent.depth+1);
		maze[i][j] = (char)('0'+updateDepth);
		
		return new MazeGraphNode(i, j, updateDepth);
	}
	
	public static void main(String[] args) {
        StepsToNearestGateInMaze s = new StepsToNearestGateInMaze();

        char[][] maze = {
                            {'_', 'W', 'G', '_', '_'},
                            {'_', '_', '_', 'W', '_'},
                            {'_', 'W', '_', 'W', 'W'},
                            {'G', 'W', '_', '_', '_'}
                        };

        s.stepsToNearestGate(maze);

        for(int i = 0; i < maze.length; ++i) {
            for(int j = 0; j < maze[0].length; ++j) {
                System.out.printf("%s ", maze[i][j]);
            }
            System.out.printf("\n");
        }

    }
	
}
