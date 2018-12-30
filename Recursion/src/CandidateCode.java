import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class CandidateCode {
	
	int n;
	int m;
	int r;
	int k;
	int[] karr; 
	int[][] marr;
	int memo[][];
	static int memoc[][];
	public static Graph graph = new Graph(1000000);
	public CandidateCode(int n, int m, int r, int[][] marr, int k, int[] karr, int[][] memo) {
		
		this.n = n;
		this.m = m;
		this.r = r;
		this.k = k;
		this.karr = karr;
		this.marr = marr;
		this.memo = memo;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();
		int[][] marr = new int[m][2]; 
		for(int k = 0; k < m ; k++) {
			for(int l = 0; l < 2; l++) {
				marr[k][l] = sc.nextInt();
				
				
			}
			graph.addEdge(marr[k][0], marr[k][1]);
		    graph.addEdge(marr[k][1], marr[k][0]);
		}
		int k = sc.nextInt();
		int[] karr = new int[k];
		int[][] memo = new int[k][k];
		memoc = new int[n+1][n+1];
		
		for(int ki = 0; ki < k; ki++) {
			karr[ki] = sc.nextInt();
		}
		
		for(int ki = 0; ki < k ; ki++) {
			for(int li = 0; li < k; li++) {
				memo[ki][li] = -1;
				
			}
		}
		
		for(int ki = 0; ki <= n ; ki++) {
			for(int li = 0; li <= n; li++) {
				memoc[ki][li] = -1;
			}
		}
		
		CandidateCode sym = new CandidateCode(n, m, r, marr, k, karr, memo);
		
		int max = findMaxSubsequenceLength(sym, 0, sym.k - 1);
		System.out.println(max);
		
	}
	private static int findMaxSubsequenceLength(CandidateCode sym, int i, int j) {

		if(sym.memo[i][j] != -1) return sym.memo[i][j];
		
		if(i == j)return sym.memo[i][j] = 1;
		
		if(i+1 == j) {
			if(sym.karr[i] == sym.karr[j]) {
				return sym.memo[i][j] = 2;
			}
			if(checkTransformTrue(sym, sym.karr[i], sym.karr[j]) == 1) {
				return sym.memo[i][j] = 2;
			}
			return sym.memo[i][j] = 1;
		}
		
		if(sym.karr[i] == sym.karr[j] || checkTransformTrue(sym, sym.karr[i], sym.karr[j]) == 1) {
			if(sym.memo[i + 1][j - 1] != -1)return sym.memo[i][j] = 2 + sym.memo[i + 1][j - 1];
			return sym.memo[i][j] = 2 + findMaxSubsequenceLength(sym, i + 1, j - 1);
		}
		//System.out.println("hi13" + i + " " + j);
		if(sym.memo[i][j-1] != -1 && sym.memo[i + 1][j] != -1) {
			return sym.memo[i][j] = Integer.max(sym.memo[i][j - 1], sym.memo[i + 1][j]);
		}
		
		if(sym.memo[i][j - 1] != -1) {
			return sym.memo[i][j] = Integer.max(sym.memo[i][j - 1], findMaxSubsequenceLength(sym, i + 1, j));
		}
		
		if(sym.memo[i + 1][j] != -1) {
			return sym.memo[i][j] = Integer.max(findMaxSubsequenceLength(sym, i, j - 1), sym.memo[i + 1][j]);
		}
		
		return sym.memo[i][j] = Integer.max(findMaxSubsequenceLength(sym, i, j - 1),findMaxSubsequenceLength(sym, i + 1, j));
	}
	private static int checkTransformTrue(CandidateCode sym, int i, int j) {
		
		if(memoc[i][j] != -1)return memoc[j][i] = memoc[i][j];
		if(memoc[j][i] != -1)return memoc[i][j] = memoc[j][i];
		
		return memoc[i][j] = memoc[j][i] = Graph.checkPath(sym, graph, i, j);
		
		
		
	}

}
class Graph 
{ 
	private int V;
	private LinkedList<Integer> adj[];  

	
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	 
	void addEdge(int v,int w) { adj[v].add(w); } 

	
	Boolean isReachable(int s, int d) 
	{ 
		LinkedList<Integer>temp; 

		
		boolean visited[] = new boolean[V]; 

		
		LinkedList<Integer> queue = new LinkedList<Integer>(); 

		
		visited[s]=true; 
		queue.add(s); 

		
		Iterator<Integer> i; 
		while (queue.size()!=0) 
		{ 
			
			s = queue.poll(); 

			int n; 
			i = adj[s].listIterator(); 

			
			while (i.hasNext()) 
			{ 
				n = i.next(); 

				
				if (n==d) 
					return true; 

				
				if (!visited[n]) 
				{ 
					visited[n] = true; 
					queue.add(n); 
				} 
			} 
		} 

		
		return false; 
	} 

	
	public static int checkPath(CandidateCode sym, Graph graph, int u, int v) 
	{ 
	  
    		if (graph.isReachable(u, v)) 
    			return 1; 
    		
    			return 0; 
    	
	    
	} 
}
