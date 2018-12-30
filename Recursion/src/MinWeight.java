import java.util.Scanner;

public class MinWeight {
	static int arr[][];
	static int n;
	static int memo[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		memo = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(Integer.min((minWeight(0, 1) + arr[0][1]), (minWeight(1, 0) + arr[1][0])));

	}
	private static int minWeight(int i, int j) {
		// TODO Auto-generated method stub
		
		if(memo[i][j] != 0)return memo[i][j];
		if((i+1 == n-1 && j == n - 1)||(i == n-1 && j+1 == n - 1)) {
			return memo[i][j] = arr[n-1][n-1];
		}
		if(i == n-1)return memo[i][j] = minWeight(i, j + 1) + arr[i][j + 1];
		if(j == n-1)return memo[i][j] = minWeight(i + 1, j) + arr[i + 1][j];
		
		
		return memo[i][j] = Integer.min((minWeight(i, j + 1) + arr[i][j + 1]), (minWeight(i + 1, j) + arr[i + 1][j]));
	}

}
