package TicTacToe;
//O(1) Time, O(n) space solution
public class TicTacToe2 {
	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int anitDiagonal;
	
	/** Initialize your data structure here. */
	public TicTacToe2(int n) {
		rows = new int[n];
		cols = new int[n];
	}
	
	/** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
            0: No one wins.
            1: Player 1 wins.
            2: Player 2 wins. */
	public int move(int row, int col, int player) {
		int toAdd = player == 1 ? 1 : -1;
		
		rows[row] += toAdd;
		cols[col] += toAdd;
		if (row == col) {
			diagonal += toAdd;
		}
		if (col+row == cols.length-1) {
			anitDiagonal += toAdd;
		}
		
		int size = rows.length;
		if (Math.abs(rows[row]) == size||
				Math.abs(cols[col])== size ||
				Math.abs(diagonal) == size ||
				Math.abs(anitDiagonal) == size)
			return player;
		return 0;
	}

}
