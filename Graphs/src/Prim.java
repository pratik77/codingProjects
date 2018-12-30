import java.util.LinkedList;

public class Prim {
	
	int vert;
	LinkedList<Node> adj[];
	boolean mst[];
	int key[];
	int parent[];
	
	public Prim(int vert) {
		this.vert = vert;
		this.adj = new LinkedList[vert];
		this.mst = new boolean[vert];
		this.key = new int[vert];
		this.parent = new int[vert];
		
		for(int i = 0; i < vert ; i++) {
			this.adj[i] = new LinkedList();
			this.key[i] = Integer.MAX_VALUE;
		}
		this.key[0] = 0;
		this.parent[0] = -1;
		
	}
	
	public void addEdge(int u, int v, int w) {
		adj[u].add(new Node(v, w));
		adj[v].add(new Node(u, w));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prim prim = new Prim(7);
		prim.addEdge(0, 4, 1);
		prim.addEdge(0, 6, 2);
		prim.addEdge(6, 2, 3);
		prim.addEdge(2, 1, 2);
		prim.addEdge(4, 5, 2);
		prim.addEdge(4, 3, 4);
		prim.addEdge(4, 1, 0);
		prim.primAlgo();
		prim.printPrim();
		
	}

	private void printPrim() {
		System.out.println("Edge       Weight");
		for(int i = 1; i < vert ; i++  ) {
			System.out.println(parent[i] + " - " + i + "   " + key[i]);
		}
		
	}

	private void primAlgo() {
		
		for(int count = 0; count < vert - 1; count++) {
			
			int index = findMinIndex();
			mst[index] = true;
			
			for(Node node : adj[index]) {
				if(mst[node.vert] == false && key[node.vert] > node.weight) {
					key[node.vert] = node.weight;
					parent[node.vert] = index;
					System.out.println("Index at count : "+count+ " is " + index + " Parent is : " + parent[index] + " Childs are : " + node.vert + " weight is : "+ node.weight);
				}
			}
			System.out.println("Index at count : "+count+ " is " + index + " Parent is : " + parent[index] );
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
