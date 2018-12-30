package src;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class CandidateCode {
	int[][] grid;
	Vector<Integer> plot[];
	int x1;
	int x2;
	int y1;
	int y2;
	int m;
	int n;
	int budget;
	int nplots;
	static FastReader1 fr = new FastReader1();
	public CandidateCode(String m, String n, int p, int budget) {
		this.m = Integer.parseInt(m);
		this.n = Integer.parseInt(n);
		this.grid = new int[this.n+1][this.n+1];;
		plot = new Vector[p];
		this.nplots = p;
		this.budget = budget;
		for(int i = 0; i < p; i++) {
			String[] split = new String[5];
			plot[i] = new Vector();
			split = fr.nextLine().split(",");
			
			for(int j = 0; j < 5 ; j++) {
				
				
				plot[i].add(Integer.parseInt(split[j]));
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] split = fr.nextLine().split(",");
		int budget = fr.nextInt();
		int p = fr.nextInt();
		int psize = fr.nextInt();
		CandidateCode mp = new CandidateCode(split[0], split[1], p, budget);
		System.out.println(mp.start());
	}
	private int start() {
		for(int i = 0 ; i <= m ; i ++) {
			for(int j = 0 ; j <= n ; j++) {
				grid[i][j] = -1;
			}
		}
		int largestSquare;
		if(m > n) {
			largestSquare = divideGrid(1, n);
		}
		else {
			largestSquare = divideGrid(1, m);
		}
		
		return largestSquare;
	}
	private int divideGrid(int low, int high) {
		
		if(grid[low][high] != -1) { System.out.println(grid[low][high]);return grid[low][high];}
		if(low == high && high < (m < n ?m : n)) return high - 1;
		if(low > high)return high;
		int mid = (high + low)/2;
		if(mid == 0)return 0;
		for(int i = 0; i + mid <= m; i++) {
			for(int j = 0; j + mid <= n; j++) {
				int budgetTemp = 0;
				for(int k = 0; k < nplots; k++) {
					
					if( plot[k].get(0) <= i + mid && plot[k].get(2) >= i + 1 && plot[k].get(1) <= j + mid && plot[k].get(3) >= j + 1 ) {
						
						budgetTemp += plot[k].get(4);
						
					}
				}
				if(budgetTemp <= budget) {
					
					int largestSquare = divideGrid(mid + 1, high);
					return grid[low][high] = largestSquare;
				}
			}
			
		}
		int largestSquare = divideGrid(low, mid);
		return grid[low][high] = largestSquare;
	}

}



class FastReader1 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader1() 
    { 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 

    public String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    public int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    public long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    public double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    public String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
 


} 