import java.util.Scanner;

public class Confidential {
	String str;
	int length;
	String confidential;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int loop=0,t=0;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		Confidential conf[]=new Confidential[t];
		for(loop=0;loop<t;loop++)
		{
			conf[loop]=new Confidential();
			conf[loop].length=sc.nextInt();
			conf[loop].str=sc.nextLine()+sc.nextLine();
		}
		
		for(loop=0;loop<t;loop++) {
			conf[loop].start(conf[loop]);
			System.out.println();
		}
	}
	private void start(Confidential conf) {
		// TODO Auto-generated method stub
		if(conf.str.length()==1)
		{
			System.out.println(conf.str.charAt(0));
			return;
		}
		System.out.print(conf.str.charAt((conf.str.length()-1)/2));
		moveLeft(conf,0,(conf.str.length()-1)/2-1);
		moveRight(conf,(conf.str.length()-1)/2+1,conf.str.length()-1);
	}
	private void moveLeft(Confidential conf, int left, int right) {
		// TODO Auto-generated method stub
		if(left==right) {
			System.out.print(conf.str.charAt(left));
			return;
		}
		int mid=(right+left)/2;
		if(left==mid) {
			System.out.print(conf.str.charAt(left));moveRight(conf,mid+1,right);return;
		}
		System.out.print(conf.str.charAt(mid));
		moveLeft(conf,left,mid-1);
		moveRight(conf,mid+1,right);
		
	}
	private void moveRight(Confidential conf, int left, int right) {
		// TODO Auto-generated method stub
		if(left==right) {
			System.out.print(conf.str.charAt(left));
			return;
		}
		int mid=(right+left)/2;
		if(left==mid) {
			System.out.print(conf.str.charAt(left));moveRight(conf,mid+1,right);return;
		}
		System.out.print(conf.str.charAt(mid));
		moveLeft(conf,left,mid-1);
		moveRight(conf,mid+1,right);
	}

}
