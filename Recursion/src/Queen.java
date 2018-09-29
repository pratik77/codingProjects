import java.util.Scanner;

public class Queen {
	
	int chess[][];
	int n;
	public static void main(String[] args) {
		
		Queen queen = new Queen();
		Scanner sc = new Scanner(System.in);
		queen.n=sc.nextInt();
		queen.chess=new int[queen.n][queen.n];
		queen.start(queen);
		sc.close();

	}
	private void start(Queen queen) {
		//queen.chess[0][0]=1;
		int i=0,j=0;
		if(queen.placeQueen(queen,queen.n))
		{
			System.out.println("YES");
			for(i=0;i<queen.n;i++) {
				for(j=0;j<queen.n;j++) {
					System.out.print(queen.chess[i][j] + " ");
				}
				System.out.println();
			}
		}
		else System.out.println("NO");
		
	}
	private boolean placeQueen(Queen queen, int n2) {
		// TODO Auto-generated method stub
		if(n2==0)
			return true;
		int i=0,j=0;
		for(i=0;i<queen.n;i++) {
			for(j=0;j<queen.n;j++) {
				if(isAttacked(i,j,queen))
						continue;
				queen.chess[i][j]=1;
				if(placeQueen(queen,n2-1))return true;
				queen.chess[i][j]=0;
			}
		}
		
		return false;
		
		
	}
	private boolean isAttacked(int i, int j, Queen queen) {
		// TODO Auto-generated method stub
		int x=0,y=0;
		for(x=0;x<queen.n;x++) {
			if(queen.chess[x][j]==1)return true;
		}
		
		for(y=0;y<queen.n;y++) {
			if(queen.chess[i][y]==1)return true;
		}
		
		for(x=0;x<queen.n;x++) {
			for(y=0;y<queen.n;y++) {
				//System.out.println(queen.chess[x][y]);
				if(((x+j==y+i) && (queen.chess[x][y]==1))||((x+y==i+j) && (queen.chess[x][y]==1)))
					return true;
			}
		}
		return false;
	}

}
