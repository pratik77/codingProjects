package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RainWaterStorage {

	int[] heights;
	int length;
	
	public RainWaterStorage(int[] split) {
		this.heights = split;
		this.length = split.length;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int heights[] = new int[split.length];
		for(int i = 0 ; i < split.length ; i++) {
			heights[i] = Integer.parseInt(split[i]);
		}
		RainWaterStorage rw = new RainWaterStorage(heights);
		System.out.println(rw.calculateVolume());
	}

	private int calculateVolume() {
		// TODO Auto-generated method stub
		int[] leftMax = new int[length];
		int[] rightMax = new int[length];
		
		leftMax[0] = heights[0];
		rightMax[length - 1] = heights[length - 1];
		
		int max = leftMax[0];
		for(int i = 1 ; i < length ; i++) {
			if(heights[i] > max) {
				max = heights[i];
			}
			leftMax[i] = max; 
		}
		max = rightMax[length - 1];
		for(int i = length - 2 ; i >= 0 ; i--) {
			if(heights[i] > max) {
				max = heights[i];
			}
			rightMax[i] = max; 
		}
		int volume = 0;
		for(int i = 1 ; i < length - 1 ; i++) {
			if(rightMax[i] < leftMax[i]) {
				volume += rightMax[i] - heights[i];
			}
			else
				volume += leftMax[i] - heights[i];
		}
		return volume;
		
	}

}
