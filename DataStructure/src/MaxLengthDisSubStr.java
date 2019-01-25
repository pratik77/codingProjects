import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class MaxLengthDisSubStr {

	String[] str;
	HashMap<String, Integer> res;
	
	public MaxLengthDisSubStr(String[] str) {
		this.str = str;
		res = new HashMap();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("");
		MaxLengthDisSubStr ml = new MaxLengthDisSubStr(split);
		String res = ml.findLargestSubstr();
		System.out.println(res);

	}

	private String findLargestSubstr() {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hm = new HashMap();
		int init = 0;
		int fin = 0;
		int init2 = 0;
		int currCount = 1;
		int wholeCount = 1;
		hm.put(str[0],1);
		
		for(int i = 1 ; i < str.length ; i++) {
			
			if(!hm.containsKey(str[i])) {
				hm.put(str[i], 1);
				currCount++;
			}
			else {
				hm.clear();
				hm.put(str[i], 1);
				init2 = i;
				currCount = 1;
				
			}
			if(currCount > wholeCount) {
				wholeCount = currCount;
				init = init2;
				fin = i;
			}
			
		}
		String newStr = "";
		for(int i = init ; i <= fin ; i++) {
			newStr += str[i];
		}
		return newStr;

	}

}
