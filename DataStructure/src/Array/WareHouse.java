package Array;





import java.util.Scanner;
import java.util.Stack;

public class WareHouse {

	int n;
	long arr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t;
		int loop,i;
		t=sc.nextInt();
		WareHouse[] wh=new WareHouse[t];
		for(loop=0;loop<t;loop++) {
			wh[loop]=new WareHouse();
			wh[loop].n=sc.nextInt();
			wh[loop].arr=new long[wh[loop].n];
			for(i=0;i<wh[loop].n;i++)
				wh[loop].arr[i]=sc.nextLong();
		}
		for(loop=0;loop<t;loop++)
		wh[loop].start(wh[loop],t);

	}
	private void start(WareHouse wh, int t) {
		// TODO Auto-generated method stub
		System.out.println(getMaxSacks(wh));
	}
	private long getMaxSacks(WareHouse wh) {
		// TODO Auto-generated method stub
		int i=0;
		Stack<Integer> s=new Stack<Integer>();
		long maxSacks=0;long maxSacksCurr=0;
		for(i=0;i<wh.n;) {
			if(s.empty()||(wh.arr[s.peek()]<=wh.arr[i]))
				s.push(i++);
			
			else {
				int item;
				item=s.peek();
				s.pop();
				maxSacksCurr=wh.arr[item]*(s.empty() ? i : 
                    i - s.peek() - 1);
				
				if(maxSacks<maxSacksCurr)
					maxSacks=maxSacksCurr;
				
			}
		}
		while(!s.empty()) {
			int item=s.peek();
			
			s.pop();
			maxSacksCurr=wh.arr[item]*(s.empty() ? i : 
                i - s.peek() - 1);
			if(maxSacks<maxSacksCurr)
				maxSacks=maxSacksCurr;
		}
		return maxSacks;
	}

}
