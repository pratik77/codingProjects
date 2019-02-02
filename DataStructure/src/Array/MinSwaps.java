package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinSwaps {
	
	int[] arr;
	int n;
	
	public MinSwaps(int[] arr, int n) {
		this.arr = arr;
		this.n = n;
	} 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		MinSwaps[] ms = new MinSwaps[t];
		for(int  i = 0 ; i < t ; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] split = br.readLine().split(" ");
			int size = split.length;
			int[] arr = new int[n];
			for(int j = 0 ; j < size ; j++) {
				arr[j] = Integer.parseInt(split[j]);
			}
			ms[i] = new MinSwaps(arr, n);
					
		}
		for(int i = 0 ; i < t ; i++) {
			ms[i].findMinSwaps();
		}
	}

	private void findMinSwaps() {
		// TODO Auto-generated method stub
		int count = 0;
		int length = arr.length;
		int min = arr[length - 1];
		for(int i = 0 ; i < length ; i++) {
			if(i + 3 >= arr[i]) {
				continue;
			}
			else {
				System.out.println("Too chaotic");
				return;
			}
		}
		for(int i = length - 2 ; i >= 0 ; i--) {
			if(arr[i] - i == 3) {
				count += 2;
			}
			else if(arr[i] > min) {
				count++;
			}
			else {
				min = arr[i];
			}
		}
		System.out.println(count);
	}

}
