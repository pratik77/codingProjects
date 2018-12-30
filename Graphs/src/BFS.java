import java.util.LinkedList;

class Node {
	int vert;
	int weight;

	public Node(int vert, int weight) {
		this.vert = vert;
		this.weight = weight;
	}
}

public class BFS {

	int vert;
	LinkedList<Node> adj[];
	boolean isVisited[];
	int[] level;

	public BFS(int vert) {
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
		BFS bfs = new BFS(7);
		bfs.addEdge(0, 4, 1);
		bfs.addEdge(0, 6, 2);
		bfs.addEdge(6, 2, 3);
		bfs.addEdge(2, 1, 2);
		bfs.addEdge(4, 5, 2);
		bfs.addEdge(4, 3, 4);
		bfs.addEdge(4, 1, 0);

		int level = 0;

		level = bfs.bfsSearch(0, 6);
		System.out.println(level);

	}

	private int bfsSearch(int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		LinkedList<Integer> queue = new LinkedList();
		isVisited[i] = true;
		queue.add(i);
		level[i] = 0;

		while (queue.size() != 0) {

			int s = queue.poll();
			count++;

			for (Node node : adj[s]) {

				if (node.vert == j) {
					return level[node.vert] = level[s] + 1;
				}
				if (!isVisited[node.vert]) {
					isVisited[node.vert] = true;
					queue.add(node.vert);
					level[node.vert] = level[s] + 1;
				}
			}
		}
		return -1;
	}

}
