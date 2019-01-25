package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckRank {

	String str;
	
	public CheckRank(String str) {
		super();
		this.str = str;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		CheckRank cr = new CheckRank(str);
		cr.findRank();
	}

	private void findRank() {
		// TODO Auto-generated method stub
		int fact = fact(str.length());
		int rank = 1;
		for(int i = 0 ; i < str.length() ; i++) {
			fact /= str.length() - i;
			int count = noOfLetterLessThanCurrAtRight(fact, i);
			rank += fact * count;
		}
		System.out.println(rank);
	}

	private int noOfLetterLessThanCurrAtRight(int fact, int low) {
		int length = str.length();
		int count = 0;
		// TODO Auto-generated method stub
		for(int i = low + 1 ; i < length ; i++) {
			if(str.charAt(i) < str.charAt(low)) {
				count++;
			}
		}
		return count;
	}

	private int fact(int length) {
		// TODO Auto-generated method stub
		if(length == 1) return 1;
		return length * fact(length - 1);
	}

}
