
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestClass {

	int rows;
	int cols;
	int keys[][];
	int grid[][];
	boolean[][] mst;

	public TestClass(int rows, int cols, int[][] grid) {
		this.rows = rows;
		this.cols = cols;
		this.grid = grid;
		this.keys = new int[rows][cols];
		mst = new boolean[rows][cols];

		for (int i = 0; i < rows; i++) {
			Arrays.fill(keys[i], Integer.MAX_VALUE);
		}
		keys[0][0] = 0;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int rows = Integer.parseInt(split[0]);
		int cols = Integer.parseInt(split[1]);

		int grid[][] = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			split = br.readLine().split(" ");
			for (int j = 0; j < cols; j++) {
				grid[i][j] = Integer.parseInt(split[j]);
			}
		}

		TestClass ct = new TestClass(rows, cols, grid);
		System.out.println(ct.calculateMinCost());

	}

	private int calculateMinCost() {
		// TODO Auto-generated method stub

		int blocks = rows * cols;
		int[][] resMat = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int k = 0; k < rows; k++) {
					Arrays.fill(keys[k], Integer.MAX_VALUE);
					Arrays.fill(mst[k], false);

				}
				keys[i][j] = 0;
				int levelCost = grid[i][j];
				for (int m = 0; m < blocks; m++) {

					int[] index = findMinKeyIndex();
					int row = index[0];
					int col = index[1];

					mst[row][col] = true;

					updateRight(row, col, levelCost);
					updateDown(row, col, levelCost);
					updateLeft(row, col, levelCost);
					updateTop(row, col, levelCost);

					if (keys[rows - 1][cols - 1] != Integer.MAX_VALUE && keys[0][0] != Integer.MAX_VALUE) {
						resMat[i][j] = keys[rows - 1][cols - 1] + keys[0][0];
					}

				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(min > resMat[i][j]) {
					min = resMat[i][j];
				}
			}
		}
		return min;
	}

	private void updateTop(int row, int col, int levelCost) {
		// TODO Auto-generated method stub
		if (row - 1 >= 0)
			if (mst[row - 1][col] == false
					&& keys[row - 1][col] > keys[row][col] + Math.abs(levelCost - grid[row - 1][col])) {
				keys[row - 1][col] = keys[row][col] + Math.abs(levelCost - grid[row - 1][col]);
			}
	}

	private void updateLeft(int row, int col, int levelCost) {
		// TODO Auto-generated method stub
		if (col - 1 >= 0)
			if (mst[row][col - 1] == false
					&& keys[row][col - 1] > keys[row][col] + Math.abs(levelCost - grid[row][col - 1])) {
				keys[row][col - 1] = keys[row][col] + Math.abs(levelCost - grid[row][col - 1]);
			}

	}

	private void updateDown(int row, int col, int levelCost) {
		// TODO Auto-generated method stub
		if (row + 1 <= rows - 1)
			if (mst[row + 1][col] == false
					&& keys[row + 1][col] > keys[row][col] + Math.abs(levelCost - grid[row + 1][col])) {
				keys[row + 1][col] = keys[row][col] + Math.abs(levelCost - grid[row + 1][col]);
			}

	}

	private void updateRight(int row, int col, int levelCost) {
		// TODO Auto-generated method stub
		if (col + 1 <= cols - 1)
			if (mst[row][col + 1] == false
					&& keys[row][col + 1] > keys[row][col] + Math.abs(levelCost - grid[row][col + 1])) {
				keys[row][col + 1] = keys[row][col] + Math.abs(levelCost - grid[row][col + 1]);
			}

	}

	private int[] findMinKeyIndex() {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		int[] index = new int[2];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mst[i][j] == false && keys[i][j] < min) {
					min = keys[i][j];
					index[0] = i;
					index[1] = j;
				}
			}
		}
		return index;
	}

}
