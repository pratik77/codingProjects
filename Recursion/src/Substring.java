import java.util.HashMap;
import java.util.Scanner;

public class Substring {
	int[] arr;
	int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int loop,t,i;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		Substring[] sub=new Substring[t];
		for(loop=0;loop<t;loop++) {
			sub[loop]=new Substring();
			sub[loop].n=sc.nextInt();
			sub[loop].arr=new int[sub[loop].n];
			for(i=0;i<sub[loop].n;i++)
				sub[loop].arr[i]=sc.nextInt();
		}
		
		for(loop=0;loop<t;loop++) {
			sub[loop].start(sub[loop]);
		}

	}
	private void start(Substring sub) {
		// TODO Auto-generated method stub
		int i=0,j=0,k=0,l=0,m=0,n=0,sum=sub.n;
		for(i=1;i<sub.n;i++)
		{
			for(j=0,l=i;l<sub.n;j++,l++)
			{
				//HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
				int[]count=new int[10000];
						for(m=j;m<=l;m++) {
							count[sub.arr[m]]++;
							if(count[sub.arr[m]]<=1) {continue;}
							else break;
							
						}
					if(m==l+1)sum=sum+i+1;		
					
			}
		}
		System.out.println(sum);
		
	}

}
