import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneSwapSmallNum {
	
	String[] num;
	int indexOfMinAtRight[];
	int small;
	int smallIndex = 0;
	int length;
	
	public OneSwapSmallNum(String[] num) {
		this.indexOfMinAtRight = new int[num.length];
		this.length = num.length;
		this.indexOfMinAtRight[length - 1] = -1;
		this.small = Integer.parseInt(num[length - 1]);
		this.num = num;
		this.smallIndex = length - 1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split("");
		OneSwapSmallNum os = new OneSwapSmallNum(num.clone());
		String newNum = os.findSmallNum();
		System.out.println(newNum);
	}

	private String findSmallNum() {
		// TODO Auto-generated method stub
		indexOfMinAtRight[length - 1] = -1;
		
		for(int i = length - 2 ; i >= 0 ; i--) {
			if(Integer.parseInt(num[i]) < small) {
				small = Integer.parseInt(num[i]);
				smallIndex = i;
				indexOfMinAtRight[i] = -1;
				continue;
			}
			indexOfMinAtRight[i] = smallIndex;
		}
		for(int i = 0 ; i < length ; i++) {
			if(indexOfMinAtRight[i] != -1) {
				String temp = num[i];
				num[i] = num[indexOfMinAtRight[i]];
				num[indexOfMinAtRight[i]] = temp;
				break;
			}
		}
		String newNum = "";
		for(int i = 0 ; i < length ; i++) {
			newNum += num[i];
		}
		return newNum;
	}

}
