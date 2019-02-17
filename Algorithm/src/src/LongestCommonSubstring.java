package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubstring {

	char[] str1;
	char[] str2;
	int memo[][];
	
	public LongestCommonSubstring(char[] str1, char[] str2) {
		this.str1 = str1;
		this.str2 = str2;
		memo = new int[str1.length + 1][str2.length + 1];
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		LongestCommonSubstring lcs = new LongestCommonSubstring(str1, str2);
		lcs.findLongestSubsequence();
	}

	private void findLongestSubsequence() {
		int res = 0;
		int len1 = str1.length;
		int len2 = str2.length;
		for(int i = 1 ; i <= len1 ; i++) {
			for(int j = 1 ; j <= len2 ; j++) {
				if(str1[i - 1] == str2[j - 1]) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
					res = Math.max(memo[i][j], res);
				}
				else {
					memo[i][j] = 0;
				}
			}
		}
		System.out.println(res);
	}

}
