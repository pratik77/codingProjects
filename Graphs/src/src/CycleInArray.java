package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class CycleInArray {

	int[] array;
	LinkedList<Integer>[] adj;
	boolean[] isVisited;

	public CycleInArray(int[] array) {
		super();
		this.array = array;
		this.adj = new LinkedList[array.length];
		this.isVisited = new boolean[array.length];
		for(int i = 0 ; i < array.length ; i++) {
			adj[i] = new LinkedList();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int[] arr = new int[split.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(split[i]);
		}
		CycleInArray c = new CycleInArray(arr.clone());
		int noOfCycles = c.noOfCycles();
		System.out.println(noOfCycles);

	}

	private int noOfCycles() {
		// TODO Auto-generated method stub
		int length = array.length;
		for (int i = 0; i < length; i++) {
			if (array[i] < length) {
				adj[i].add(array[i]);
			}
		}
		int count = 0;
		boolean cycleDetected = false;
		for (int i = 0; i < length; i++) {
			if (!isVisited[i]) {
				cycleDetected = checkCycle(i, i, isVisited.clone());
				if (cycleDetected) {
					cycleDetected = false;
					count++;
				}
			}
		}
		return count;
	}

	private boolean checkCycle(int i, int org, boolean[] isVisited) {
		// TODO Auto-generated method stub
		boolean cycleDetected = false;

		isVisited[i] = true;
		for (int j : adj[i]) {
			if(j == org) {
				return true;
			}
			if (!isVisited[j]) {
				isVisited[j] = true;
				if(checkCycle(j, org, isVisited)) {
					this.isVisited[j] = true;
					return true;
				}
				return false;

			}
			else
				return false;

		}

		return false;

	}

}
