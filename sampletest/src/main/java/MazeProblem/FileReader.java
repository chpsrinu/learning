package MazeProblem;

import java.io.File;
import java.util.Scanner;

public class FileReader {

	private int[][] map;
	private String fileName;
	private int numOfRows;
	private int numOfColumns;
	private int startPositionCol;
	private int startPositionRow;
	
	public FileReader(String fileName, int numOfRows, int numOfCols) {
		this.fileName = fileName;
		this.numOfRows = numOfRows;
		this.numOfColumns = numOfCols;
		this.map = new int[numOfRows][numOfCols];
	}
	
	public void parseFile() {
		try {
			Scanner scanner = new Scanner(new File(this.fileName));
			
			for(int i=0;i<this.numOfRows;i++) {
				for(int j=0;j<this.numOfColumns;j++) {
					map[i][j] = scanner.nextInt();
					if(map[i][j] == 2) {
						this.startPositionRow = i;
						this.startPositionCol = j;
					}
				}
			}
			scanner.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getStartPositionCol() {
		return this.startPositionCol;
	}
	
	public int getStartPositionRow() {
		return this.startPositionRow;
	}
	
	public int[][] getMap() {
		return this.map;
	}
}
