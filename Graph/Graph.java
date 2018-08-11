import java.util.LinkedList;

public class Graph {

	public LinkedList<Edge> adj[];// adjacency list

	/**
	 * Initialize adjacency list
	 * @param vertices, number of nodes in a graph
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	Graph(int vertices) {
		adj = new LinkedList[vertices];
		
		for (int i = 0; i < vertices; i++) {
			adj[i] = new LinkedList();//initializing linked list at each index in the array
		}
	}

	/**
	 * Adding an edge in the graph
	 * @param vertex, adding an edge in corresponding vertex's array
	 * @param e, edge 
	 */
	void addEdge(int vertex, Edge e) {
		adj[vertex].add(e);
	}

}
