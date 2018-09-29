import java.util.Scanner;

public class Horse {
	int [][] chess;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int i,j,n;
		i=sc.nextInt();
		j=sc.nextInt();
		n=sc.nextInt();
		Horse horse=new Horse();
		horse.chess=new int[10][10];
		horse.start(horse,i-1,j-1,n);
		int x=0,y=0,count=0;
		for(x=0;x<10;x++)
		{
			for(y=0;y<10;y++)
			{
				if(horse.chess[x][y]==1)count++;
			}
		}
		System.out.println(count);
		sc.close();

	}
	private void start(Horse horse, int i, int j, int n) {
		// TODO Auto-generated method stub
		findPos(horse,i,j,n);
		
	}
	private void findPos(Horse horse, int i, int j, int n) {
		// TODO Auto-generated method stub
		if(n==0 &&horse.chess[i][j]!=1) {
			horse.chess[i][j]=1;
			return;
		}
		else if(n==0)return;
		if(i-2>=0&&j-1>=0)
			findPos(horse,i-2,j-1,n-1);
		if(i-2>=0&&j+1<10)
			findPos(horse,i-2,j+1,n-1);
		if(i-1>=0&&j+2<10)
			findPos(horse,i-1,j+2,n-1);
		if(i+1<10&&j+2<10)
			findPos(horse,i+1,j+2,n-1);
		if(i+2<10&&j+1<10)
			findPos(horse,i+2,j+1,n-1);
		if(i+2<10&&j-1>=0)
			findPos(horse,i+2,j-1,n-1);
		if(i+1<10&&j-2>=0)
			findPos(horse,i+1,j-2,n-1);
		if(i-1>=0&&j-2>=0)
			findPos(horse,i-1,j-2,n-1);
	}

}
