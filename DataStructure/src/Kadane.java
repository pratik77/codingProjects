import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kadane {
	
	int[] arr;
	public Kadane(int[] arr) {
		this.arr = arr;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(", ");
		int[] arr = new int[split.length];
		for(int i = 0 ; i < split.length ; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		Kadane k = new Kadane(arr);
		k.findMaxSumSubArray();

	}

	private void findMaxSumSubArray() {
		// TODO Auto-generated method stub
		int maxSum = arr[0];
		int init = 0;
		int initChange = 0;
		int fin = 0;
		int[] state = new int[arr.length];
		state[0] = arr[0];
		for(int i = 1 ; i < arr.length ; i++) {
			state[i] = state[i - 1] + arr[i];
			if(state[i] < arr[i]) {
				state[i] = arr[i];
				initChange = i;
			}
			if(state[i] > maxSum) {
				maxSum = state[i];
				fin = i;
				init = initChange;
			}
			
		}
		System.out.println("Max Sum : " + maxSum);
		System.out.println("Initial index : " + init + " Final index : " + fin);
		
	}

}
