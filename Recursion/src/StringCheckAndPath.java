import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCheckAndPath {

	String[][] matrix;
	String testStr;
	int row;
	int col;

	public StringCheckAndPath(String[][] matrix, String testStr) {
		this.matrix = matrix;
		this.testStr = testStr;
		this.row = this.matrix.length;
		this.col = this.matrix[0].length;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row = Integer.parseInt(br.readLine());
		int col = Integer.parseInt(br.readLine());
		String[][] matrix = new String[row][col];
		for (int i = 0; i < row; i++) {
			String[] split = br.readLine().split("");
			matrix[i] = split;
		}
		String testStr = br.readLine();
		StringCheckAndPath sc = new StringCheckAndPath(matrix, testStr);

		String path = sc.findPath();
		System.out.println(path);
	}

	private String findPath() {
		// TODO Auto-generated method stub
		int row = matrix.length;
		int col = matrix[0].length;
		String path = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				if (matrix[i][j].charAt(0) == testStr.charAt(0)) {
					path = checkPath(i, j + 1, "R", 1);
					if (path.contains("No Path")) {
						path = checkPath(i + 1, j, "D", 1);
					}
					if (!path.contains("No Path"))
						return path;
				}
			}

		}
		return "No Path";
	}

	private String checkPath(int i, int j, String direction, int k) {
		// TODO Auto-generated method stub
		String path = "";
		if (matrix[i][j].charAt(0) != testStr.charAt(k))
			return "No Path";
		if (k == testStr.length() - 1) {
			return direction;
		}
		if (i == row - 1 && j == col - 1)
			return "No Path";
		if (i == row - 1) {
			return path = direction + checkPath(i, j + 1, "R", k + 1);
		}
		if (j == col - 1) {
			return path = direction + checkPath(i + 1, j, "D", k + 1);
		}
		path = direction + checkPath(i, j + 1, "R", k + 1);
		if (path.contains("No Path")) {
			path = direction + checkPath(i + 1, j, "D", k + 1);
		}
		return path;

		
	}

}