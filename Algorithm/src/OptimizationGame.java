import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimizationGame {

	int[] arr;
	public OptimizationGame(int[] arr) {
		this.arr = arr;
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		OptimizationGame[] test = new OptimizationGame[t];
		for(int tt = 0 ; tt < t ; tt++) {
			int length = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split(" ");
			int[] arr = new int[length + 1];
			for(int i = 0 ; i < length; i++) {
				arr[i] = Integer.parseInt(split[i]);
			}
			test[tt] = new OptimizationGame(arr);
		}
		
		for(int tt = 0 ; tt < t ; tt++) {
			System.out.println(test[tt].calculateSumOfNewArray());
		}

	}

	private long calculateSumOfNewArray() {
		// TODO Auto-generated method stub
		int length = arr.length;
		int quo = 0;
		int rem = 0;
		int res = 0;
		int quoRes = 0;
		int remRes = 0;
		for(int i = 0 ; i < length - 1 ; i++) {
			quoRes = res / 2;
			remRes = res % 2;
			quo = arr[i] / 2;
			rem = arr[i] % 2;
			quo += (rem + remRes) / 2;
			rem = (rem + remRes) % 2;
			arr[i] = rem;
			res = quo + quoRes;
		}
		int sum = 0;
		while(res > 1) {
			sum += res%2;
			res /= 2;
		}
		sum += res;
		
		for(int i = 0 ; i < length - 1 ; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
