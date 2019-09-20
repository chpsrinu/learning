package QueensProblem;

public class QueensProblem {
	private int[][] chessTable;
	private int numOfQueens;
	
	public QueensProblem(int numOfQueens) {
		this.chessTable = new int[numOfQueens][numOfQueens];
		this.numOfQueens = numOfQueens;
	}
	
	public void solve() {
		if(setQueens(0)) {
			printQueens();
		} else {
			System.out.println("There is no solution...");
		}
	}

	private boolean setQueens(int columnIndex) {
		
		if( columnIndex == numOfQueens ) {
			return true;
		}
		
		for (int rowIndex = 0; rowIndex<numOfQueens;++rowIndex) {
			
			if ( isPlaceValid(rowIndex, columnIndex) ) {
				chessTable[rowIndex][columnIndex] = 1;
				
				if( setQueens(columnIndex+1)) {
					return true;
				}
				
				//BACKTRACKING !!!
				chessTable[rowIndex][columnIndex] = 0;
				
			}
		}
		return false;
	}

	private boolean isPlaceValid(int rowIndex, int columnIndex) {
		
		 for (int i=0;i<columnIndex;i++) {
			 if (chessTable[rowIndex][i] == 1) {
				 return false;
			 }
		 }
		 
		 for (int i=rowIndex, j=columnIndex;i>=0 && j>=0;i--,j--) {
			 if(chessTable[i][j] == 1)
				 return false;
		 }
		 
		 for (int i=rowIndex,j=columnIndex;i<chessTable.length && j>=0;i++,j--) {
			 if(chessTable[i][j] == 1) 
				 return false;
		 }
		 
		
		
		return true;
	}

	private void printQueens() {
		
		for (int i=0;i<chessTable.length;i++) {
			for (int j=0;j<chessTable.length;j++) {
				if (chessTable[i][j] == 1) {
					System.out.print(" * ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}

}
