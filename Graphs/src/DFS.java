import java.util.LinkedList;

class Node {
	int vert;
	int weight;

	public Node(int vert, int weight) {
		this.vert = vert;
		this.weight = weight;
	}
}


public class DFS {

	int vert;
	LinkedList<Node> adj[];
	boolean isVisited[];
	int[] level;

	public DFS(int vert) {
		this.vert = vert;
		adj = new LinkedList[vert];
		isVisited = new boolean[vert];
		for (int i = 0; i < vert; i++) {
			adj[i] = new LinkedList();
		}
		level = new int[vert];
	}

	public void addEdge(int u, int v, int w) {

		adj[u].add(new Node(v, w));
		adj[v].add(new Node(u, w));

	}

	public static void main(String[] args) {

		FastReader fs = new FastReader();
		DFS DFS = new DFS(7);
		DFS.addEdge(0, 4, 1);
		
		DFS.addEdge(6, 2, 3);
		DFS.addEdge(2, 1, 2);
		DFS.addEdge(4, 5, 2);
		DFS.addEdge(4, 3, 4);
		DFS.addEdge(4, 1, 0);
		DFS.addEdge(0, 6, 2);

		String level;

		level = DFS.DFSSearch(3, 2, 3);
		System.out.println(level);

	}

	private String DFSSearch(int i, int j, int s) {
		// TODO Auto-generated method stub
		int check;
		isVisited[i] = true;

			for (Node node : adj[i]) {

				if (node.vert == j) {
					return "found";
				}
				if (!isVisited[node.vert]) {
					isVisited[node.vert] = true;
					level[node.vert] = level[i] + 1;
					return DFSSearch(node.vert, j, s);
					
				}
			}
		
		return "not found";
	}

}
