import java.util.Scanner;

public class CandidateCode {
	char[] pattern;
	int size;
	int memo[][];
	public CandidateCode(int size, char[] pattern) {
		this.size = size;
		this.pattern = pattern;
		this.memo = new int[size][size];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CandidateCode mi = new CandidateCode(Integer.parseInt(sc.next()), (sc.nextLine() + sc.nextLine()).toCharArray());
		
		for(int i = 0; i < mi.size; i++) {
			for(int j = 0; j < mi.size; j++) {
				mi.memo[i][j] = -1;
			}
		}
		
		int min = findMinInsertion(mi, 0, mi.size - 1);
		 
		System.out.println(min);
		
		
	}

	private static int findMinInsertion(CandidateCode mi, int i, int j) {
		if(mi.memo[i][j] != -1) return mi.memo[i][j];
		if(i == j)return mi.memo[i][j] = 0;
		// TODO Auto-generated method stub
		
		if(i+1 == j) {
			if(mi.pattern[i] == mi.pattern[j]) {
				return mi.memo[i][j] = 0;
			}
			return mi.memo[i][j] = 1;
		}
		
		if(mi.pattern[i] == mi.pattern[j]) {
			if(mi.memo[i + 1][j - 1] != -1)return mi.memo[i][j] = mi.memo[i + 1][j - 1];
			return mi.memo[i][j] = findMinInsertion(mi, i + 1, j - 1);
		}
		
		if(mi.memo[i][j-1] != -1 && mi.memo[i + 1][j] != -1) {
			return mi.memo[i][j] = Integer.min(mi.memo[i][j - 1], mi.memo[i + 1][j]) + 1;
		}
		
		if(mi.memo[i][j - 1] != -1) {
			return mi.memo[i][j] = Integer.min(mi.memo[i][j - 1], findMinInsertion(mi, i + 1, j)) + 1;
		}
		
		if(mi.memo[i + 1][j] != -1) {
			return mi.memo[i][j] = Integer.min(findMinInsertion(mi, i, j - 1), mi.memo[i + 1][j]) + 1;
		}
		
		return mi.memo[i][j] = Integer.min(findMinInsertion(mi, i, j - 1),findMinInsertion(mi, i + 1, j)) + 1;
	}

	

}
