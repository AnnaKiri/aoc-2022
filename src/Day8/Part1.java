package Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
	
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
		
		int counter = 0;
		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[i].length - 1; j++) {
				if (getTreeVisibility(grid, i, j)) {
					counter++;
				}
			}
		}
		
		int result = counter + (ROWS*2 + COLUMNS*2) - 4;
		
		System.out.println(result);

	}
	
	public static boolean getTreeVisibility(int[][] grid, int x, int y) {
		boolean upIsVisible = true;	
		for (int i = x - 1; i >= 0; i--) {		// идем вверх
			if (grid[i][y] >= grid[x][y]) {
				upIsVisible = false;
				break;
			}		
		}
		if (upIsVisible) {
			return true;
		}
		
		boolean downIsVisible = true;
		for (int i = x + 1; i < ROWS; i++) {	// идем вниз
			if (grid[i][y] >= grid[x][y]) {
				downIsVisible = false;
				break;
			} 
		}
		if (downIsVisible) {
			return true;
		}

		boolean leftIsVisible = true;
		for (int i = y - 1; i >= 0; i--) {		// идем влево
			if (grid[x][i] >= grid[x][y]) {
				leftIsVisible = false;
				break;
			}	
		}
		if (leftIsVisible) {
			return true;
		}
		
		boolean rightIsVisible = true;
		for (int i = y + 1; i < COLUMNS; i++) {		// идем вправо
			if (grid[x][i] >= grid[x][y]) {
				rightIsVisible = false;
				break;
			}	
		}
		if (rightIsVisible) {
			return true;
		}
		
		return false;
		
	}
}
