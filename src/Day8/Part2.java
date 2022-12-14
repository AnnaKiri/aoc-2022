package Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {
	
	final static int ROWS = 99;
	final static int COLUMNS = 99;
	
	public static void main(String[] args) throws IOException {
		String path = ".\\src\\Day8\\data.txt";
		final String [] array = Files.readString(Path.of(path)).lines().toArray(String[]::new);

		int[][] grid = new int [ROWS][COLUMNS];
		
		for (int i = 0; i < array.length; i++) {			//кол-во строк в grid совпадает с кол-вом элементов в array
			for (int k = 0; k < array[i].length(); k++) {	// кол-во солбцов совпадает с кол-вом символов в каждом элементое (строке) в array
				grid[i][k] = Integer.parseInt(String.valueOf(array[i].charAt(k)));
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int value = getTreeVisibility(grid, i, j);
				if (value > max) {
					max = value;
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	public static int getTreeVisibility(int[][] grid, int x, int y) {
		int treesAbove = 0;
		for (int i = x - 1; i >= 0; i--) {		// идем вверх
			treesAbove++;
			if (grid[i][y] >= grid[x][y]) {
				break;
			}		
		}
		int treesBelow = 0;
		for (int i = x + 1; i < ROWS; i++) {	// идем вниз
			treesBelow++;
			if (grid[i][y] >= grid[x][y]) {
				break;
			} 
		}
		
		int treesLeft = 0;
		for (int i = y - 1; i >= 0; i--) {		// идем влево
			treesLeft++;
			if (grid[x][i] >= grid[x][y]) {
				break;
			}	
		}
		
		int treesRight = 0;
		for (int i = y + 1; i < COLUMNS; i++) {		// идем вправо
			treesRight++;
			if (grid[x][i] >= grid[x][y]) {
				break;
			}	
		}
		
		int scenicScore = treesAbove * treesBelow * treesLeft * treesRight;
		
		return scenicScore;
		
	}
}