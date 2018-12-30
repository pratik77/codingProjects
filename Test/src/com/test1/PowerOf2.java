package com.test1;
import java.util.HashMap;
import java.util.Scanner;

public class PowerOf2 {
	
	
	int[] prod;
	int test1 = 1;
	int test2 = 2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
		
		PowerOf2 po = new PowerOf2();
		//Arrays.fill(po.prod, 0);
		
		int x = 0;
		int pointer = 0;
		System.out.println("Enter n of n power y: ");
		int n = sc.nextInt();
		System.out.println("Enter y of n power y: ");
		int y = sc.nextInt();
		
		int noOfDigits = (int) (y * Math.log10(n) + 1);
		//System.out.println(Math.log10(n));
		po.prod = new int[noOfDigits];
		po.prod[0] = 1;
		
		for(int i = 1; i <= y ; i++) {
			int buffer = 0;
			pointer = 0;
			while(pointer < noOfDigits) {
				int rem = (po.prod[pointer] * n + buffer) % 10;
				int quo = (po.prod[pointer] * n + buffer) / 10;
				po.prod[pointer] = rem;
				buffer = quo;
			pointer++ ;
			}
		}
		int sum = 0;
		for(int i = noOfDigits - 1 ; i >= 0 ; i--) {
			System.out.print(po.prod[i]);
			sum += po.prod[i];
		}
		System.out.println();
		System.out.println(sum);
		TestClass tc = new TestClass();
		tc.test1 = 2;
		tc.test2 = 3;
		tc.testMethod();
		
		
		//int x = 2+2**2;

	}
	private void testMethod() {
		// TODO Auto-generated method stub
		System.out.println(test1 + test2);
	}

}

class TestClass{
	int test1;
	int test2;
	int[] ii = new int[5];
	 void testMethod() {
		// TODO Auto-generated method stub
		System.out.println(test1 + test2);
	}
}
