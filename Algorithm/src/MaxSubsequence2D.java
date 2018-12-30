

import java.util.Arrays;

public class MaxSubsequence2D {
	int mat[][];
	int row, col;
	int gmax[][];
	static FastReader fs = new FastReader();

	public MaxSubsequence2D(int row, int col) {
		this.row = row;
		this.col = col;
		this.mat = new int[row][col];
		this.gmax = new int[row][col];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int row = fs.nextInt();
		int col = fs.nextInt();
		MaxSubsequence2D maxS = new MaxSubsequence2D(row, col);
		System.out.println(maxS.start());

	}

	private int start() {
		// TODO Auto-generated method stub
		int k = 0, l = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < row ; i++) {
			for(int j = 0; j < col ; j++) {
				mat[i][j] = fs.nextInt();
				if(i == 0 && j == 0) {
					gmax[0][0] = mat[0][0];
					max = gmax[0][0];
				}
				else if(i == 0) {
					if(gmax[i][j-1] + mat[i][j] > mat[i][j]) {
						gmax[i][j] = gmax[i][j-1] + mat[i][j];
						
					}
					else
						gmax[i][j] = mat[i][j];
				}
				else if(j == 0) {
					if(gmax[i - 1][j] + mat[i][j] > mat[i - 1][j]) {
						gmax[i][j] = gmax[i - 1][j] + mat[i][j];
						
					}
					else
						gmax[i][j] = mat[i][j];
				}
				else {
					//gmax[i][j] = (gmax[i][j - 1] > gmax[i - 1][j] ? (gmax[i][j - 1] + mat[i][j] > mat[i][j] ? gmax[i][j - 1] + mat[i][j] : mat[i][j]) : (gmax[i - 1][j] + mat[i][j] > mat[i][j] ? gmax[i - 1][j] + mat[i][j] : mat[i][j]));
					int hor = gmax[i][j - 1];
					int ver = gmax[i - 1][j];
					if(hor + ver + mat[i][j] > mat[i][j]) gmax[i][j] = hor + ver + mat[i][j];
					else if(hor + mat[i][j] > mat[i][j]) gmax[i][j] = hor + mat[i][j];
					else if(ver + mat[i][j] > mat[i][j]) gmax[i][j] = ver + mat[i][j];
					else gmax[i][j] = mat[i][j];
				
				}
				if(max < gmax[i][j]) { max = gmax[i][j];
						k = i; l = j;
				}
			}
		}
		System.out.println(k + " " + l);
		return max;
		
	}

}
