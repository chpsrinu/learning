import java.util.*;

public class Solution
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int numberAmazonTreasureTrucks(int rows, int column,
								   List<List<Integer> > grid)
    {
        // WRITE YOUR CODE HERE
        int count = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<column;j++) {
                if(grid.get(i).get(j) == 1) {
                    count++;
                    markNeighbours(grid, i, j, rows, column);
                }
            }
        }
        return count;
    }
    // METHOD SIGNATURE ENDS
    
    private static void markNeighbours(List<List<Integer>> grid, int i, int j, int row, int column) {
        if(i<0 || i>=row || j<0 || j>=column || grid.get(i).get(j) == 0) return;
        grid.get(i).set(j,0);
        markNeighbours(grid, i+1, j, row, column);
        markNeighbours(grid, i-1, j, row, column);
        markNeighbours(grid, i, j+1, row, column);
        markNeighbours(grid, i, j-1, row, column);
    }
    
    public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		List<Integer> l4 = new ArrayList<>();
		List<Integer> l5 = new ArrayList<>();
		List<Integer> l6 = new ArrayList<>();
		List<Integer> l7 = new ArrayList<>();
		l1.add(1);
		l1.add(0);
		l1.add(0);
		l1.add(0);
		l1.add(0);
		l1.add(0);
		l1.add(0);
		
		l2.add(0);
		l2.add(1);
		l2.add(0);
		l2.add(0);
		l2.add(0);
		l2.add(0);
		l2.add(0);
		
		l3.add(0);
		l3.add(0);
		l3.add(1);
		l3.add(0);
		l3.add(0);
		l3.add(0);
		l3.add(0);
		
		l4.add(0);
		l4.add(0);
		l4.add(0);
		l4.add(1);
		l4.add(0);
		l4.add(0);
		l4.add(0);
		
		l5.add(0);
		l5.add(0);
		l5.add(0);
		l5.add(0);
		l5.add(1);
		l5.add(0);
		l5.add(0);
		
		l6.add(0);
		l6.add(0);
		l6.add(0);
		l6.add(0);
		l6.add(0);
		l6.add(1);
		l6.add(0);
		
		l7.add(0);
		l7.add(0);
		l7.add(0);
		l7.add(0);
		l7.add(0);
		l7.add(0);
		l7.add(1);
		
		List<List<Integer>> lis = new ArrayList<List<Integer>>();
		lis.add(l1);
		lis.add(l2);
		lis.add(l3);
		lis.add(l4);
		lis.add(l5);
		lis.add(l6);
		lis.add(l7);
		
		System.out.println(numberAmazonTreasureTrucks(7,7,lis));
	}
}