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
		us.count = us.countUni(0, str.length() - 1);
		System.out.println(us.count);
	}

	private int countUni(int i, int j) {
		// TODO Auto-generated method stub
		if(memo[i][j] != -1)
			return 0;
		if(i == j){
			return memo[i][j] = 1;
		}
		int count = 0;
		for(int k = i ; k <= j ; k++){
			int idx = str.charAt(k) - 'A';
			alphaCount[idx] += 1; 
		}
		count = countUniqueChars();
		return memo[i][j] = (count % MOD + countUni(i, j - 1) % MOD + countUni(i + 1, j) % MOD) % MOD;
		
	}

	private int countUniqueChars() {
		int count = 0;
		for(int i = 0 ; i < 26 ; i++){
			if(alphaCount[i] == 1)
				count++;
		}
		clearAlphaCount();
		return count;
	}

	private void clearAlphaCount() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < 26 ; i++){
			alphaCount[i] = 0;
		}
	}

}
