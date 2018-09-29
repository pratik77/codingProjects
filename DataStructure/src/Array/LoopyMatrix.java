package Array;

import java.io.IOException;
import java.util.Scanner;


public class LoopyMatrix {
	String loopyMatrix[][];
	int size;
	static int count = 1;
	static String r;
	public LoopyMatrix(int t) {
		// TODO Auto-generated constructor stub
		this.size = t;
		this.loopyMatrix = new String[t][t];
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter matrix size : ");
		int t = Integer.parseInt(args[0]);
		
		LoopyMatrix loopyMatrix = new LoopyMatrix(t);
		//t = Integer.parseInt(args[0]);
		r = generateString(loopyMatrix);;
		long start = System.currentTimeMillis();
		initializeMatrix(loopyMatrix);
		arrangeMatrix(loopyMatrix);
		//printMatrix(loopyMatrix);
		long end = System.currentTimeMillis();
		//System.out.println('\f');
		
		System.out.println(end - start+" ms");
		//System.out.println("Hi");
		//System.out.print("\033[H\033[2J");  
		//Thread.sleep(2000);
	    //System.out.println("Hi");
		
		//System.out.print('\f');
		//System.out.println("\f");

		//System.out.println("\u000c");
		sc.close();
	}
	private static void initializeMatrix(LoopyMatrix loopyMatrix) {
		// TODO Auto-generated method stub
		for(int i = 0; i < loopyMatrix.size; i++)
			for(int j = 0; j < loopyMatrix.size; j++)
				loopyMatrix.loopyMatrix[i][j] = r;
		
	}
	private static void printMatrix(LoopyMatrix loopyMatrix) {
		// TODO Auto-generated method stub
		int i = 0, j = 0, size = loopyMatrix.size;
		for(i = 0; i < size; i++) {
			System.out.println();
			for(j = 0; j<size; j++)
				System.out.print(loopyMatrix.loopyMatrix[i][j]);
		}
		
	}
	private static void arrangeMatrix(LoopyMatrix loopyMatrix) throws InterruptedException {
		// TODO Auto-generated method stub
		int n = loopyMatrix.size;
		
		int i = 0;
		int j = 1;
		loopyMatrix.loopyMatrix[0][0] = Integer.toString(count++) + padding(count - 1, loopyMatrix);
		pattern(loopyMatrix);
		goRight(loopyMatrix, i , j);
		//goDown(loopyMatrix, i+1, j-1);
		
		
		
	}
	private static String padding(int i, LoopyMatrix loopyMatrix2) {
		// TODO Auto-generated method stub
			return r.substring(0, Integer.toString(loopyMatrix2.size * loopyMatrix2.size).length() - Integer.toString(i).length() + 1);
	}
	private static String generateString(LoopyMatrix loopyMatrix2) {
		// TODO Auto-generated method stub
		int stringSize = Integer.toString(loopyMatrix2.size * loopyMatrix2.size).length();
		String generatedSpace = "";
		for(int i = 0; i <= stringSize; i++)
			generatedSpace += " ";
		return generatedSpace;
	}
	private static void pattern(LoopyMatrix loopyMatrix) throws InterruptedException {
		System.out.print("\033[H\033[2J");
		//Thread.sleep(400);
		printMatrix(loopyMatrix);
		Thread.sleep(50);
	}
	private static void goRight(LoopyMatrix loopyMatrix, int i, int j) throws InterruptedException {
		// TODO Auto-generated method stub
		if(j == loopyMatrix.size)return;
		if(!r.equals(loopyMatrix.loopyMatrix[i][j]))return;
		loopyMatrix.loopyMatrix[i][j] = Integer.toString(count++) + padding(count - 1, loopyMatrix);
		pattern(loopyMatrix);
			goRight(loopyMatrix, i, j+1);
			goDown(loopyMatrix, i+1, j);
		
		
	}
	private static void goDown(LoopyMatrix loopyMatrix, int i, int j) throws InterruptedException {
		if(i == loopyMatrix.size)return;
		if(!r.equals(loopyMatrix.loopyMatrix[i][j]))return;
		loopyMatrix.loopyMatrix[i][j] = Integer.toString(count++) + padding(count - 1, loopyMatrix);
		pattern(loopyMatrix);
			goDown(loopyMatrix, i+1, j);
			goLeft(loopyMatrix, i, j-1);
	}
	private static void goLeft(LoopyMatrix loopyMatrix, int i, int j) throws InterruptedException {
		if(j < 0)return;
		if(!r.equals(loopyMatrix.loopyMatrix[i][j]))return;
		loopyMatrix.loopyMatrix[i][j] = Integer.toString(count++) + padding(count - 1, loopyMatrix);
		pattern(loopyMatrix);
			goLeft(loopyMatrix, i, j-1);
			goTop(loopyMatrix, i-1, j);
	}
	private static void goTop(LoopyMatrix loopyMatrix, int i, int j) throws InterruptedException {
		if(i < 0)return;
		if(!r.equals(loopyMatrix.loopyMatrix[i][j]))return;
		loopyMatrix.loopyMatrix[i][j] = Integer.toString(count++) + padding(count - 1, loopyMatrix);
		pattern(loopyMatrix);
			goTop(loopyMatrix, i-1, j);
			goRight(loopyMatrix, i, j+1);
	}

}