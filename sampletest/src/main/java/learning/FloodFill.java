package learning;

import java.util.*;

public class FloodFill {

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		int startColor = image[sr][sc];
        if (startColor == newColor) return image;
        int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        Queue<int[]> que = new LinkedList();
        que.offer(new int[]{sr, sc});
        while (!que.isEmpty()) {
            int[] pos = que.poll();
            image[pos[0]][pos[1]] = newColor;
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != startColor) continue;
                que.offer(new int[]{x, y});
                //image[x][y] = newColor;
            }
        }
        return image;
    }
    
    
    
    public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(floodFill(image, 1, 1, 2));
	}
}
