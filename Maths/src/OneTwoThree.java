import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class OneTwoThree {

	int[] arr;
	
	public OneTwoThree(int[] arr) {
		this.arr = arr;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int k = 0;
		while(n > 0) {
			arr[k++] = Integer.parseInt(br.readLine());
			n--;
		}
		String res = checkNumbers(arr);
		System.out.println(res);

	}

	private static String checkNumbers(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		boolean one = false;
		boolean two = false;
		boolean three = false;
		int[] resarr = new int[len];
		int k = 0;
		for(int i = 0 ; i < len ; i++) {
			int num = arr[i];
			int s = num;
			while(num > 0) {
				int rem = num % 10;
				if(rem == 1)one = true;
				else if(rem == 2)two = true;
				else if(rem == 3)three = true;
				num /= 10;
			}
			
			if(one == true && two == true && three == true) {
				resarr[k++] = s;
			}
			one = false;
			two = false;
			three = false;
			
		}
		Arrays.sort(resarr);
		String res = "";
		for(int i = 0 ; i  < resarr.length ; i++) {
			Integer j = resarr[i];
			res += j.toString();
			if(i != resarr.length - 1) {
				res += ",";
				
			}
		}
		if(resarr.length == 0) res = "-1";
		return res;
	}

}
