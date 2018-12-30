
class Index{
	int i;
	int j;
	public Index() {
		this.i = 0;
		this.j = 0;
	}
}

public class MinCostPath {
	int[][] matrix = {{31, 100, 65, 12, 18}, {10, 2, 47, 157, 6}, {100, 113, 6, 11, 33}, {88, 124, 41, 20, 140}, {99, 32, 111, 41, 20}};
	int key[][];
	boolean mst[][];
	
	public MinCostPath() {
		int x = Integer.MAX_VALUE;
		this.key = new int[this.matrix.length][this.matrix.length];
		for(int i = 0; i < this.matrix.length; i++) {
			for(int j = 0 ; j < this.matrix[i].length ; j++) {
				this.key[i][j] = x;
			}
		}
		mst = new boolean[this.matrix.length][this.matrix.length];
		key[0][0] = 0;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinCostPath mn = new MinCostPath();
		int edges = mn.matrix.length * mn.matrix.length - 1;
		int row  = mn.matrix.length;
		int col = row;
		
		for(int i = 0; i < edges ; i++) {
			
			Index index = mn.minIndex();
			
			mn.mst[index.i][index.j] = true;
			
			if(index.i < row - 1 && index.i > 0 && index.j < col - 1 && index.j > 0 ) {
				updateUp(mn, index);
				updateRight(mn, index);
				updateDown(mn, index);
				updateLeft(mn, index);
					
			}
			
			else if(index.i == row - 1 && index.j == col - 1) {
				break;
			}
			
			else if(index.i == 0 && index.j == 0) {
				updateDown(mn, index);
				updateRight(mn, index);
			}
			
			else if(index.i == 0 && index.j == col - 1) {
				updateDown(mn, index);
				updateLeft(mn, index);
			}
			
			else if(index.i == row - 1 && index.j == 0) {
				updateUp(mn, index);
				updateRight(mn, index);
			}
			else if(index.i == row - 1) {
				updateUp(mn, index);
				updateRight(mn, index);
				updateLeft(mn, index);
				
			}
			else if(index.i == 0) {
				updateDown(mn, index);
				updateRight(mn, index);
				updateLeft(mn, index);
				
			}
			
			else if(index.j == col - 1) {
				updateUp(mn, index);
				updateDown(mn, index);
				updateLeft(mn, index);
			}
			
			else {
				updateDown(mn, index);
				updateUp(mn, index);
				updateRight(mn, index);
				
			}
			
			
			
			
			
		}
		System.out.println(mn.key[row - 1][col - 1] + mn.matrix[0][0]);

	}

	private static void updateLeft(MinCostPath mn, Index index) {
		if(mn.mst[index.i][index.j - 1] == false && mn.key[index.i][index.j - 1] > mn.key[index.i][index.j] + mn.matrix[index.i][index.j - 1]) {
			mn.key[index.i][index.j - 1] = mn.key[index.i][index.j] + mn.matrix[index.i][index.j - 1];
			
		}
	}

	private static void updateDown(MinCostPath mn, Index index) {
		if(mn.mst[index.i + 1][index.j] == false && mn.key[index.i + 1][index.j] > mn.key[index.i][index.j] + mn.matrix[index.i + 1][index.j]) {
			mn.key[index.i + 1][index.j] = mn.key[index.i][index.j] + mn.matrix[index.i + 1][index.j];
			
		}
	}

	private static void updateRight(MinCostPath mn, Index index) {
		if(mn.mst[index.i][index.j + 1] == false && mn.key[index.i][index.j + 1] > mn.key[index.i][index.j] + mn.matrix[index.i][index.j + 1]) {
			mn.key[index.i][index.j + 1] = mn.key[index.i][index.j] + mn.matrix[index.i][index.j + 1];
			
		}
	}

	private static void updateUp(MinCostPath mn, Index index) {
		if(mn.mst[index.i - 1][index.j] == false && mn.key[index.i - 1][index.j] > mn.key[index.i][index.j] + mn.matrix[index.i - 1][index.j]) {
			mn.key[index.i - 1][index.j] = mn.key[index.i][index.j] + mn.matrix[index.i - 1][index.j];
			
		}
	}

	private Index minIndex() {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		Index minIndex = new Index();
		for(int i = 0; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix.length ; j++) {
				if(key[i][j] < min && mst[i][j] == false) {
					min = key[i][j];
					minIndex.i = i;
					minIndex.j = j;
				}
			}
		}
		return minIndex;
	}

}
