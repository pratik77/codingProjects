import java.util.Scanner;

public class EggBreak {
	int memo[][];
	int floors;
	int eggs;
	
	public EggBreak(int eggs, int floors) {
		this.floors = floors;
		this.eggs = eggs;
		this.memo = new int[eggs + 1][floors + 1];
	
		for(int i = 0 ; i <= floors ; i++) {
			memo[1][i] = i;
		}
		for(int i = 2 ; i <= eggs ; i++) {
			for(int j = 1 ; j <= floors ; j++) {
				memo[i][j] = Integer.MAX_VALUE;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		EggBreak eb = new EggBreak(sc.nextInt(), sc.nextInt());
		int findMinAttempt = eb.findMinAttempt(eb.eggs, eb.floors);
		System.out.println(findMinAttempt);
		
	}

	private int findMinAttempt(int eggs, int floors) {
		// TODO Auto-generated method stub
		//System.out.println(eggs+ " " + floors);
		if(memo[eggs][floors] != Integer.MAX_VALUE)
			return memo[eggs][floors] ;
		
		int min = Integer.MAX_VALUE;
		for(int i = 1 ; i <= floors ; i++) {
			memo[eggs - 1][i - 1] = findMinAttempt(eggs - 1, i - 1);
			memo[eggs][floors - i] = findMinAttempt(eggs, floors - i);
			
			int compare;
			compare = 1 + Integer.max(memo[eggs - 1][i - 1], memo[eggs][floors - i]);
			if (compare < min) {
				min = compare;
			}
		}
		return memo[eggs][floors] = min;
				
	}

}
