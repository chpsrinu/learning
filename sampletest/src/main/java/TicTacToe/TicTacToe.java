package TicTacToe;

//O(n) Time, O(n^2) space solution
public class TicTacToe {

	private char[][] board;
	private static char X = 'X';
	private static char O = 'O';
	private int size;
	
	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		board = new char[n][n];
		size = n;
	}
	
	/** Player {player} makes a move at ({row},{col}).
	 	@param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
	public int move(int row, int col, int player) {
		char c;
		if (player == 1)
			c = X;
		else
			c = O;
		
		if (board[row][col] != 0) {
			// throw error, occupied
			return 0;
		}
		board[row][col] = c;
		
		if (hasWon(row, col, size, c)) {
			return player;
		}
		return 0;
	}
	
	private boolean hasWon(int row, int col, int n, char c) {
		
		// check horizontal
		boolean rowLine = true;
		for (int i=0;i<n;i++) {
			rowLine = rowLine && (board[i][col] == c);
		}
		// check vertical
		boolean colLine = true;
		for (int j=0;j<n;j++) {
			colLine = colLine && (board[row][j] == c);
		}
		// check diagonal
		if (row+col == n-1 || row == col) {
			boolean diagLine1 = true;
			boolean diagLine2 = true;
			for (int j=0;j<n;j++) {
				diagLine1 = diagLine1 && (board[j][j] == c);
			}
			for (int j=0;j<n;j++) {
				diagLine2 = diagLine2 && (board[n-1-j][j] == c);
			}
			return rowLine || colLine || diagLine1 || diagLine2;
		} else
			return rowLine || colLine;
	}
}
