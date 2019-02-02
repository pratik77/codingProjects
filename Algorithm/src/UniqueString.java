import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UniqueString {

	String str;
	int memo[][];
	int count = 0;
	static int[] alphaCount = new int[26];
	static final int  MOD = 1000000007;
	public UniqueString(String str){
		this.str = str;
		int length = str.length();
		int count = 0;
		memo = new int[length][length];
		for(int i = 0 ; i < length ; i++){
			Arrays.fill(memo[i], -1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		UniqueString us = new UniqueString(str);
		int sum = us.countUni();
		System.out.println(sum);
	}

	private int countUni() {
		// TODO Auto-generated method stub
		int len = str.length();
		int sum = 0;
		for(int i = 0 ; i < len ; i++) {
			memo[i][i] = 1;
		}
		for(int gap = 1 ; gap < len; gap++) {
			int k = gap;
			for(int j = 0 ; k < len ; j++) {
				if(str.charAt(j) == str.charAt(k)) 
					memo[j][k] = memo[j + 1][k - 1];
				else 
					memo[j][k] = 1 + Math.min(memo[j][k - 1], memo[j + 1][k]);
				k++;
			}
		}
		for(int i = 0 ; i < len ; i++) {
			for(int j = i ; j < len ; j++) {
				sum = (sum % MOD + memo[i][j] % MOD) % MOD;
			}
		}
		return sum;
		
	}

}