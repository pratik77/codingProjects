package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Orange{
	int i;
	int j;
	int pass;
	int val;
	public Orange(int i, int j, int val) {
		this.i = i;
		this.j = j;
		pass = -1;
		this.val = val;
	}
}

public class RottenOranges {

	Orange[][] oranges;
	int[][] grid;
	int rows;
	int cols;
	
	public RottenOranges(int rows, int cols, int[][] grid, Orange[][] oranges) {
		this.rows = rows;
		this.cols = cols;
		this.grid = grid;
		this.oranges = oranges;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = br.readLine().split(" ");
		int rows = Integer.parseInt(split[0]);
		int cols = Integer.parseInt(split[1]);
		int[][] grid = new int[rows][cols];
		for(int i = 0 ; i < rows ; i++) {
			split = br.readLine().split("");
			for(int j = 0 ; j < cols ; j++) {
				grid[i][j] = Integer.parseInt(split[j]);
			}
		}
		LinkedList<Orange> bfs = new LinkedList();
		Orange[][] oranges = new Orange[rows][cols];
		for(int i = 0 ; i < rows ; i++) {
			for(int j = 0 ; j < cols ; j++) {
				oranges[i][j] = new Orange(i, j, grid[i][j]);
				if(grid[i][j] == 2) {
					oranges[i][j].pass = 0;
					bfs.add(oranges[i][j]);
				}
			}
		}
		RottenOranges ro = new RottenOranges(rows, cols, grid, oranges);
		int time = ro.findTime(bfs);
		System.out.println(time);
	}
	private int findTime(LinkedList<Orange> bfs) {
		// TODO Auto-generated method stub
		while(!bfs.isEmpty()) {
			//System.out.println("hi");
			Orange orange = bfs.poll();
			rotTop(orange.i - 1, orange.j, orange.pass + 1, bfs);
			rotRight(orange.i, orange.j + 1, orange.pass + 1, bfs);
			rotDown(orange.i + 1, orange.j, orange.pass + 1, bfs);
			rotLeft(orange.i, orange.j - 1, orange.pass + 1, bfs);
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < rows ; i++) {
			for(int j = 0 ; j < cols ; j++) {
				if(oranges[i][j].val == 1) {
					return -1;
				}
				else if(max < oranges[i][j].pass && oranges[i][j].val == 2) {
					max = oranges[i][j].pass;
				}
			}
		}
		return max;
	}
	private void rotLeft(int i, int j, int pass, LinkedList<Orange> bfs) {
		if(j < 0) return;
		setToBfs(i, j, pass, bfs);
	}
	private void rotDown(int i, int j, int pass, LinkedList<Orange> bfs) {
		if(i >= rows) return;
		setToBfs(i, j, pass, bfs);
	}
	private void rotRight(int i, int j, int pass, LinkedList<Orange> bfs) {
		if(j >= cols) return;
		setToBfs(i, j, pass, bfs);
	}
	private void rotTop(int i, int j, int pass, LinkedList<Orange> bfs) {
		if(i < 0) return;
		setToBfs(i, j, pass, bfs);
	}
	private void setToBfs(int i, int j, int pass, LinkedList<Orange> bfs) {
		if(oranges[i][j].val == 0) return;
		if(oranges[i][j].val == 2) return;
		oranges[i][j].pass = pass;
		oranges[i][j].val = 2;
		bfs.add(oranges[i][j]);
	}

}
