import java.util.Scanner;

public class AwesomeSequence {
	int k;
	int arr[];
	int q;
	long[] m;
	
	static double constant=Math.pow(10, 9)+7;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AwesomeSequence sequence = new AwesomeSequence();
		sequence.k = sc.nextInt();
		sequence.arr = new int[sequence.k];
		int i = 0;
		for (i = 0; i < sequence.k; i++) {
			sequence.arr[i] = sc.nextInt();
		}
		sequence.q = sc.nextInt();
		sequence.m = new long[sequence.q];
		for (i = 0; i < sequence.q; i++) {
			sequence.m[i] = sc.nextLong();
		}
		sequence.start(sequence);

		sc.close();

	}

	private void start(AwesomeSequence sequence) {
		//sequence.sequence[0] = 1;
		int i=0;
		for(i=0;i<sequence.q;i++) {
			System.out.println(getSequenceNum(sequence.m[i],sequence));
		}
	}

	private long getSequenceNum(long m2, AwesomeSequence sequence) {
		// TODO Auto-generated method stub
		if(m2==0)return 1;
		
		
		long nearestPower=m2;
		nearestPower=nearestPower|(nearestPower>>1);
		nearestPower=nearestPower|(nearestPower>>2);
		nearestPower=nearestPower|(nearestPower>>4);
		nearestPower=nearestPower|(nearestPower>>8);
		nearestPower=nearestPower|(nearestPower>>16);
		nearestPower=(nearestPower+1)>>1;
		
		return  (long) ((getSequenceNum(m2^nearestPower,sequence)%constant+sequence.arr[(int) (m2%sequence.k)]%constant)%constant);
		
	}

	
}
