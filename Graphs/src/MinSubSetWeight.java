
public class MinSubSetWeight {
	 //int[][] matrix = {{2, 1, 1, 2, 3, 1}, {1, 0, 2, 4, 1, 2}, {1, 2, 2, 1, 0, 1},
	//{3, 0, 4, 1, 2, 1}, {4, 1, 2, 0, 2, 1}};
	int[][] matrix = { { 0, 10, 0 }, { 10, 100, 10 }, { 0, 10, 0 } };
	int key[][];
	boolean mst[][];
	Index[][] parent;
	static int v = 0;
	static int u = 0;
	static int accumulator = 0;

	public MinSubSetWeight() {
		int x = Integer.MAX_VALUE;
		int col = this.matrix[0].length;
		this.key = new int[this.matrix.length][col];
		this.parent = new Index[this.matrix.length][col];
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < col; j++) {
				this.key[i][j] = x;
				this.parent[i][j] = new Index();
			}
		}
		mst = new boolean[this.matrix.length][col];
		key[0][0] = 0;
		parent[0][0].i = -1;
		parent[0][0].j = -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MinSubSetWeight mn = new MinSubSetWeight();
		int col = mn.matrix[0].length;
		int edges = mn.matrix.length * col - 1;
		int row = mn.matrix.length;

		int x = 0, y = 0;
		for (int i = 0; i < edges; i++) {

			Index index = mn.minIndex();

			mn.mst[index.i][index.j] = true;

			if (index.i < row - 1 && index.i > 0 && index.j < col - 1 && index.j > 0) {
				updateUp(mn, index);
				updateRight(mn, index);
				updateDown(mn, index);
				updateLeft(mn, index);
				updateNE(mn, index);
				updateSE(mn, index);
				updateSW(mn, index);
				updateNW(mn, index);

			}

			else if (index.i == row - 1 && index.j == col - 1) {
				updateUp(mn, index);
				updateLeft(mn, index);
				updateNW(mn, index);
			}

			else if (index.i == 0 && index.j == 0) {
				updateDown(mn, index);
				updateRight(mn, index);
				updateSE(mn, index);
			}

			else if (index.i == 0 && index.j == col - 1) {
				updateDown(mn, index);
				updateLeft(mn, index);
				updateSW(mn, index);
			}

			else if (index.i == row - 1 && index.j == 0) {
				updateUp(mn, index);
				updateRight(mn, index);
				updateNE(mn, index);
			} else if (index.i == row - 1) {
				updateUp(mn, index);
				updateRight(mn, index);
				updateLeft(mn, index);
				updateNE(mn, index);
				updateNW(mn, index);

			} else if (index.i == 0) {
				updateDown(mn, index);
				updateRight(mn, index);
				updateLeft(mn, index);
				updateSE(mn, index);
				updateSW(mn, index);

			}

			else if (index.j == col - 1) {
				updateUp(mn, index);
				updateDown(mn, index);
				updateLeft(mn, index);
				updateSW(mn, index);
				updateNW(mn, index);
			}

			else {
				updateDown(mn, index);
				updateUp(mn, index);
				updateRight(mn, index);
				updateNE(mn, index);
				updateSE(mn, index);

			}
			System.out.print("v = " + v + " Indexes = " + index.i + " " + index.j);
			if (u != v) {
				accumulator += mn.matrix[index.i][index.j];
				u = v;
				System.out.println(" accumulator = " + accumulator);
				if (v == 3) {
					break;
				}
			}
			System.out.println();

		}
		// System.out.println("Edge Weight");
		// for(int i = 0; i < row ; i++ ) {
		// for(int j = 0 ; j < col ; j++) {
		// if(i == 1 && j == 1) continue;
		// System.out.println("( "+mn.parent[i][j].i+" - "+mn.parent[i][j].j+" )" + " -
		// " + " ( "+i +" - "+j+" ) "+ " " + mn.key[i][j]);
		// }
		// }

		System.out.println(accumulator);

	}

	private static void updateLeft(MinSubSetWeight mn, Index index) {
		// if(mn.mst[index.i][index.j - 1] == false && mn.key[index.i][index.j - 1] >
		// mn.matrix[index.i][index.j - 1]) {
		// mn.key[index.i][index.j - 1] = mn.matrix[index.i][index.j - 1];
		// mn.parent[index.i][index.j - 1] = index;
		//
		// }
		if (mn.matrix[index.i][index.j - 1] == 0 && mn.mst[index.i][index.j - 1] == false)
			v++;
		if (mn.mst[index.i][index.j - 1] == false
				&& mn.key[index.i][index.j - 1] > mn.key[index.i][index.j] + mn.matrix[index.i][index.j - 1]) {
			mn.key[index.i][index.j - 1] = mn.key[index.i][index.j] + mn.matrix[index.i][index.j - 1];

		}
	}

	private static void updateDown(MinSubSetWeight mn, Index index) {
		// if(mn.mst[index.i + 1][index.j] == false && mn.key[index.i + 1][index.j] >
		// mn.matrix[index.i + 1][index.j]) {
		// mn.key[index.i + 1][index.j] = mn.matrix[index.i + 1][index.j];
		// mn.parent[index.i + 1][index.j] = index;
		// }
		if (mn.matrix[index.i + 1][index.j] == 0 && mn.mst[index.i + 1][index.j] == false)
			v++;
		if (mn.mst[index.i + 1][index.j] == false
				&& mn.key[index.i + 1][index.j] > mn.key[index.i][index.j] + mn.matrix[index.i + 1][index.j]) {
			mn.key[index.i + 1][index.j] = mn.key[index.i][index.j] + mn.matrix[index.i + 1][index.j];

		}
	}

	private static void updateRight(MinSubSetWeight mn, Index index) {
		// if(mn.mst[index.i][index.j + 1] == false && mn.key[index.i][index.j + 1] >
		// mn.matrix[index.i][index.j + 1]) {
		// mn.key[index.i][index.j + 1] = mn.matrix[index.i][index.j + 1];
		// mn.parent[index.i][index.j + 1] = index;
		// }
		if (mn.matrix[index.i][index.j + 1] == 0 && mn.mst[index.i][index.j + 1] == false)
			v++;
		if (mn.mst[index.i][index.j + 1] == false
				&& mn.key[index.i][index.j + 1] > mn.key[index.i][index.j] + mn.matrix[index.i][index.j + 1]) {
			mn.key[index.i][index.j + 1] = mn.key[index.i][index.j] + mn.matrix[index.i][index.j + 1];

		}
	}

	private static void updateUp(MinSubSetWeight mn, Index index) {
		// if(mn.mst[index.i - 1][index.j] == false && mn.key[index.i - 1][index.j] >
		// mn.matrix[index.i - 1][index.j]) {
		// mn.key[index.i - 1][index.j] = mn.matrix[index.i - 1][index.j];
		// mn.parent[index.i - 1][index.j] = index;
		// }
		if (mn.matrix[index.i - 1][index.j] == 0 && mn.mst[index.i - 1][index.j] == false)
			v++;
		if (mn.mst[index.i - 1][index.j] == false
				&& mn.key[index.i - 1][index.j] > mn.key[index.i][index.j] + mn.matrix[index.i - 1][index.j]) {
			mn.key[index.i - 1][index.j] = mn.key[index.i][index.j] + mn.matrix[index.i - 1][index.j];

		}
	}

	private static void updateNE(MinSubSetWeight mn, Index index) {
		// if(mn.mst[index.i - 1][index.j + 1] == false && mn.key[index.i - 1][index.j +
		// 1] > mn.matrix[index.i - 1][index.j + 1]) {
		// mn.key[index.i - 1][index.j + 1] = mn.matrix[index.i - 1][index.j + 1];
		// mn.parent[index.i - 1][index.j + 1] = index;
		// }
		if (mn.matrix[index.i - 1][index.j + 1] == 0 && mn.mst[index.i - 1][index.j + 1] == false)
			v++;
		if (mn.mst[index.i - 1][index.j + 1] == false
				&& mn.key[index.i - 1][index.j + 1] > mn.key[index.i][index.j] + mn.matrix[index.i - 1][index.j + 1]) {
			mn.key[index.i - 1][index.j + 1] = mn.key[index.i][index.j] + mn.matrix[index.i - 1][index.j + 1];

		}
	}

	private static void updateSE(MinSubSetWeight mn, Index index) {
		// if(mn.mst[index.i + 1][index.j + 1] == false && mn.key[index.i + 1][index.j +
		// 1] > mn.matrix[index.i + 1][index.j + 1]) {
		// mn.key[index.i + 1][index.j + 1] = mn.matrix[index.i + 1][index.j + 1];
		// mn.parent[index.i + 1][index.j + 1] = index;
		// }
		if (mn.matrix[index.i + 1][index.j + 1] == 0 && mn.mst[index.i + 1][index.j + 1] == false)
			v++;
		if (mn.mst[index.i + 1][index.j + 1] == false
				&& mn.key[index.i + 1][index.j + 1] > mn.key[index.i][index.j] + mn.matrix[index.i + 1][index.j + 1]) {
			mn.key[index.i + 1][index.j + 1] = mn.key[index.i][index.j] + mn.matrix[index.i + 1][index.j + 1];

		}
	}

	private static void updateSW(MinSubSetWeight mn, Index index) {
		// if(mn.mst[index.i + 1][index.j - 1] == false && mn.key[index.i + 1][index.j -
		// 1] > mn.matrix[index.i + 1][index.j - 1]) {
		// mn.key[index.i + 1][index.j - 1] = mn.matrix[index.i + 1][index.j - 1];
		// mn.parent[index.i + 1][index.j - 1] = index;
		// }
		if (mn.matrix[index.i + 1][index.j - 1] == 0 && mn.mst[index.i + 1][index.j - 1] == false)
			v++;
		if (mn.mst[index.i + 1][index.j - 1] == false
				&& mn.key[index.i + 1][index.j - 1] > mn.key[index.i][index.j] + mn.matrix[index.i + 1][index.j - 1]) {
			mn.key[index.i + 1][index.j - 1] = mn.key[index.i][index.j] + mn.matrix[index.i + 1][index.j - 1];

		}
	}

	private static void updateNW(MinSubSetWeight mn, Index index) {
		// if(mn.mst[index.i - 1][index.j - 1] == false && mn.key[index.i - 1][index.j -
		// 1] > mn.matrix[index.i - 1][index.j - 1]) {
		// mn.key[index.i - 1][index.j - 1] = mn.matrix[index.i - 1][index.j - 1];
		// mn.parent[index.i - 1][index.j - 1] = index;
		// }
		if (mn.matrix[index.i - 1][index.j - 1] == 0 && mn.mst[index.i - 1][index.j - 1] == false)
			v++;
		if (mn.mst[index.i - 1][index.j - 1] == false
				&& mn.key[index.i - 1][index.j - 1] > mn.key[index.i][index.j] + mn.matrix[index.i - 1][index.j - 1]) {
			mn.key[index.i - 1][index.j - 1] = mn.key[index.i][index.j] + mn.matrix[index.i - 1][index.j - 1];

		}
	}

	private Index minIndex() {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		Index minIndex = new Index();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (key[i][j] < min && mst[i][j] == false) {
					min = key[i][j];
					minIndex.i = i;
					minIndex.j = j;
				}
			}
		}
		return minIndex;
	}

}
