package learning;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/discuss/interview-question/347457
public class TreasureIsland {

	private static final int[][] DIRS = {{1,0},{0,1},{-1,0},{0,-1}};
	
	public static void main(String[] args) {
		char[][] island = new char[][]{
				{'O', 'O', 'O', 'O'},
				{'D', 'O', 'D', 'O'},
				{'O', 'O', 'O', 'O'},
				{'X', 'D', 'D', 'O'}
		};
		int result = treasureIsland(island);
		System.out.println(String.format("%s (expect 5)", result));
	}
	
	static class Position {
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static int treasureIsland(char[][] island) {
		if(island == null || island.length ==0) return 0;
		
		Queue<Position> queue = new LinkedList<TreasureIsland.Position>();
		queue.add(new Position(0,0));
		island[0][0] = 'D';
		for(int steps = 1; !queue.isEmpty();steps++) {
			for(int sz = queue.size();sz>0;sz--) {
				Position p = queue.poll();
				for (int[] dir: DIRS) {
					int r = p.x+dir[0];
					int c = p.y+dir[1];
					
					if(isSafe(island, r, c)) {
						if(island[r][c] == 'X') return steps;
						island[r][c] = 'D';
						queue.add(new Position(r, c));
					}
				}
			}
		}
		return -1;
	}

	private static boolean isSafe(char[][] island, int r, int c) {
		return r>=0 && r<island.length && c>=0 && c<island[0].length && island[r][c] != 'D';
	}
	
}
