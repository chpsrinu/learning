package learning;

import java.util.ArrayList;
import java.util.List;

//https://www.programcreek.com/2014/06/leetcode-word-search-ii-java/
public class WordSearch {

	public List<String> findWords(char[][] board, String[] words) {
		ArrayList<String> result = new ArrayList<>();
		
		int m = board.length;
		int n = board[0].length;
		
		for (String word : words) {
			boolean flag = false;
			for(int i = 0;i<m;i++) {
				for(int j=0;j<n;j++) {
					char[][] newBoard = new char[m][n];
					for(int x=0;x<m;x++) {
						for (int y=0;y<n;y++) {
							newBoard[x][y] = board[x][y];
						}
					}
					if(dfs(newBoard, word, i , j, 0)) {
						flag = true;
					}
				}
			} 
			if (flag)
				result.add(word);
		}
		return result;
	}
	
	public boolean dfs(char[][] board, String word, int i, int j, int k) {
		int m = board.length;
		int n = board[0].length;
		
		if (i<0 || j<0 || i >= m || j >= n || k > word.length()-1) {
			return false;
		}
		
		if (board[i][j] == word.charAt(k)) {
			char temp = board[i][j];
			board[i][j] = '#';
			
			if ( k == word.length() -1) {
				return true;
			} else if(dfs(board, word, i-1, j, k+1) || dfs(board, word, i+1,j, k+1) || dfs(board, word, i, j-1, k+1) || dfs(board, word, i, j+1, k+1)) {
				board[i][j] = temp;
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
}

//https://leetcode.com/problems/word-search/discuss/915727/Java-DFS-solution
class Solution {
    
    //TC: O(m*n) SC: O(m*n) => worst case me might have to keep all the chars in the recursion stack
    public boolean exist(char[][] board, String word) {
        
        //look for the first letter and call dfs for the remaining
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                   return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) return true;
        
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || 
            board[i][j] == '*' || board[i][j] != word.charAt(index)) return false;
        
        board[i][j] = '*';
        
        boolean found = dfs(board, i-1, j, word, index+1) ||
            dfs(board, i+1, j, word, index+1) || 
            dfs(board, i, j-1, word, index+1) ||
            dfs(board, i, j+1, word, index+1);
        
        board[i][j] = word.charAt(index);
        return found;
    }
}
