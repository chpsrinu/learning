package learning;

import java.awt.Point;
import java.util.LinkedList;
import java.util.*;

public class MatrixProblem {
	int minimumDays(int rows, int columns, List<List<Integer> > grid)
    {
		
        
	Point point = new Point(-1, -1);
	int mark = 0;
	for(int i = 1;i<grid.size()-1;i++)
	{
		for (int j = 1; j < grid.get(i).size() - 1; j++) {
			int localPoint = 0;
			if (grid.get(i - 1).get(j) == 0) {
				localPoint++;
			}
			if (grid.get(i).get(j - 1) == 0) {
				localPoint++;
			}
			if (grid.get(i + 1).get(j) == 0) {
				localPoint++;
			}
			if (grid.get(i).get(j + 1) == 0) {
				localPoint++;
			}
			if (localPoint > mark) {
				point.x = i;
				point.y = j;
				mark = localPoint;
			}
		}
	}
	Queue<Point> points = new LinkedList<>();points.offer(point);
	int days = 0;while(!points.isEmpty())
	{
		Point currentPoint = points.poll();
		if (isValidPoint(currentPoint.x - 1, currentPoint.y, grid)) {
			points.offer(new Point(currentPoint.x - 1, currentPoint.y));
			grid.set(currentPoint.x - 1, grid,get(currentPoint.x - 1).get(currentPoint.y) = 1;
		}
		if (isValidPoint(currentPoint.x + 1, currentPoint.y, grid)) {
			points.offer(new Point(currentPoint.x + 1, currentPoint.y));
			grid[currentPoint.x + 1][currentPoint.y] = 1;
		}
		if (isValidPoint(currentPoint.x, currentPoint.y - 1, grid)) {
			points.offer(new Point(currentPoint.x, currentPoint.y - 1));
			grid[currentPoint.x][currentPoint.y - 1] = 1;
		}
		if (isValidPoint(currentPoint.x, currentPoint.y + 1, grid)) {
			points.offer(new Point(currentPoint.x, currentPoint.y + 1));
			grid[currentPoint.x][currentPoint.y + 1] = 1;
		}
		days++;
	}

	System.out.println(days);
	}

private static boolean isValidPoint(int x, int y, int[][] grid) {
return !(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1);
}
}
}
