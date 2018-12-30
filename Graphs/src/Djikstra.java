 import java.util.LinkedList;

public class Djikstra {
	
	int vert;
	LinkedList<Node> adj[];
	boolean mst[];
	int key[];
	int parent[];
	int source;
	
	public Djikstra(int vert, int source) {
		this.vert = vert;
		this.adj = new LinkedList[vert];
		this.mst = new boolean[vert];
		this.key = new int[vert];
		this.parent = new int[vert];
		
		for(int i = 0; i < vert ; i++) {
			this.adj[i] = new LinkedList();
			this.key[i] = Integer.MAX_VALUE;
		}
		this.key[source] = 0;
		this.parent[source] = -1;
		this.source = source;
	}
	
	public void addEdge(int u, int v, int w) {
		adj[u].add(new Node(v, w));
		adj[v].add(new Node(u, w));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Djikstra dj = new Djikstra(7, 6);
		dj.addEdge(0, 4, 1);
		dj.addEdge(0, 6, 2);
		dj.addEdge(6, 2, 3);
		dj.addEdge(2, 1, 2);
		dj.addEdge(4, 5, 2);
		dj.addEdge(4, 3, 4);
		dj.addEdge(4, 1, 0);
		dj.djikstraAlgo();
		dj.printDjikstra();
		
	}

	private void printDjikstra() {
		System.out.println("Edge       Weight");
		for(int i = 0; i < vert ; i++  ) {
			if(i == source) continue;
			System.out.println(source + " - " + i + "   " + key[i]);
		}
		
	}

	private void djikstraAlgo() {
		
		for(int count = 0; count < vert - 1; count++) {
			
			int index = findMinIndex();
			mst[index] = true;
			
			for(Node node : adj[index]) {
				if(mst[node.vert] == false && key[node.vert] > node.weight + key[index]) {
					key[node.vert] = node.weight + key[index];
					parent[node.vert] = index;
					
				}
			}
			
		}
		
	}

	private int findMinIndex() {
		
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		
		for(int i = 0 ; i < vert ; i++) {
			if(mst[i] == false && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
			
		}
		return minIndex;
		
	}

}
