import java.util.Scanner;

public class LCMofArray {
	
	int size;
	int[] arr;
	
	public LCMofArray(int size) {
		this.size = size;
		this.arr = new int[size];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the matrix : ");
		
		LCMofArray lcmObj = new LCMofArray(sc.nextInt());
		
		System.out.println("Enter the elements of the array : ");
		
		for(int i = 0; i < lcmObj.size; i++) {
			lcmObj.arr[i] = (i + 1);
		}
		
		int lcm = 1;
		long start = System.currentTimeMillis();
		lcm = findLCM(lcm, lcmObj, 0);
		long end = System.currentTimeMillis();
		System.out.println("LCM is : " + lcm);
		System.out.println("Time taken : " + (end - start));
	
	}

	private static int findLCM(int lcm, LCMofArray lcmObj, int i) {
		// TODO Auto-generated method stub
		
		if(i == lcmObj.size)
			return lcm;
		
		lcm = lcm * lcmObj.arr[i] / findGCD(lcm, lcmObj.arr[i]);
		int lcmNext = findLCM(lcm, lcmObj, i + 1);
		return lcmNext;
		
	}

	private static int findGCD(int x, int y) {
		// TODO Auto-generated method stub
		while(x != y) {
			if(x > y)
				x = x - y;
			else if(y > x)
				y -= x;
			
			else
				return x;
		}
		return x;
	}

}
