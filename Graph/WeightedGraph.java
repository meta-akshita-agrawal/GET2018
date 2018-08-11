import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class WeightedGraph implements UndirectedWeighted {

	Graph edgeList;
	LinkedList<Edge> adj[];
	boolean[] visited;
	HashMap<Integer, Edge> mst = new HashMap<>();

	/**
	 * Parameterized Constructor
	 * Initializing a graph with vertices
	 * Retrieving adjacency list in adj
	 * @param vertices
	 */
	WeightedGraph(int vertices) {
		edgeList = new Graph(vertices);
		adj = edgeList.adj;
	}

	/**
	 * Adding edge
	 * @param vertex
	 * @param e
	 */
	public void addEdge(int vertex, Edge e) {
		edgeList.addEdge(vertex, e);
	}

	/**
	 * Checks if a graph is connected or not
	 * Using DFS approach
	 */
	@Override
	public boolean isConnected() {

		visited = new boolean[adj.length];//keeps track of visited nodes

		dfs(1);//invoking dfs method with a random vertex 1

		for (int i = 0; i < adj.length; i++) {
			if (!visited[i]) {
				return false;//if after dfs traversal any of the nodes remain unvisited it means graph is disconnected
			}
		}
		return true;//else its connected
	}

	/**
	 * Recursive DFS traversal
	 * Helper method for isConnected
	 * @param vertex
	 */
	private void dfs(int vertex) {

		visited[vertex] = true;//sets a vertex true

		Iterator<Edge> itr = adj[vertex].listIterator();//creates an iterator for vertex's neighbours

		while (itr.hasNext()) {
			Edge e = itr.next();//retrieve a neighboring edge

			if (!visited[e.nodeId]) {//if not visited recursively called
				dfs(e.nodeId);
			}
		}

	}

	/**
	 * @param vertex
	 * @return a path reachable from a vertex
	 */
	@Override
	public LinkedList<Integer> reachable(int vertex) {
		
		LinkedList<Integer> reachableNodes = new LinkedList<>();

		Iterator<Edge> itr = adj[vertex].listIterator();

		while (itr.hasNext()) {
			Edge e = itr.next();
			reachableNodes.add(e.nodeId);
		}
		return reachableNodes;
	}

	
	/**
	 * Returns a minimum spanning tree with source, destination and weight between them
	 * Minimum spanning tree is a graph with no cycles or loops
	 * Uses Prim's algorithm
	 * Invokes a recursive method prim
	 */
	@Override
	public HashMap<Integer, Edge> mst() {
		
		visited = new boolean[adj.length];
		
		prim(0, new LinkedList<>());//invoking recursive method
		
		return mst;
	}

	/**
	 * Recursive method to evaluate shortest tree from the graph
	 * This method basically do a BFS traversal 
	 * @param vertex, to explore
	 * @param listOfTempEdges, list of neighboring edges of visited nodes
	 */
	private void prim(int vertex, LinkedList<EdgeWithSourceDest> listOfTempEdges) {

		visited[vertex] = true;//marking index as visited

		Iterator<Edge> itr = adj[vertex].listIterator();//iterating through neighboring edges

		while (itr.hasNext()) {
			Edge e = itr.next();
			if (!visited[e.nodeId]) {
				listOfTempEdges.add(new EdgeWithSourceDest(vertex, e.nodeId, e.weight));//adding edges in the list
			}
		}

		Iterator<EdgeWithSourceDest> edgeListItr = listOfTempEdges.listIterator();//creating an iterator for edges in the temp list

		EdgeWithSourceDest current = listOfTempEdges.get(0);//setting current pointer to the start of list
		
		int min = Integer.MAX_VALUE;
		
		while (edgeListItr.hasNext()) {
			
			EdgeWithSourceDest e = edgeListItr.next();
			
			if (min > e.weight && !mst.containsKey(e.destination)) {//checks if new weight is less than minimum as well as
				min = e.weight;										//not present in the minimum spanning tree
				current = e;
			}

		}

		if (!visited[current.destination]) {
			mst.put(current.destination, (new Edge(current.source, current.weight)));//adding the current edge in mst
			listOfTempEdges.remove(current);//removing this edge from temp list
		}

		if (!isEveryNodeTraversed(visited)) {//checks if every node is traversed or not
			prim(current.destination, listOfTempEdges);//RECURSIVE
		} else {//if yes then recursion stops
			return;
		}
	}

	/**
	 * Checks if any node is unvisited
	 * @param visited
	 * @return true if every node is visited at least once else false
	 */
	private boolean isEveryNodeTraversed(boolean[] visited) {
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {//checks if any node is marked as false
				return false;
			}
		}
		return true;
	}

	/**
	 * @return a stack of shortest path from a to b
	 */
	@Override
	public Stack<Integer> shorestPath(int a, int b) {

		Stack<Integer> pathStack = new Stack<>();
		
		int[][] costTable = createTable();//retrieving cost table from method create table
		
		//tracking path from the table by moving to previous pointers 
		//and pushing them to stack until another node is reached
		
		int pointer = b;

		while (pointer != a) {
			pathStack.push(pointer);
			pointer = costTable[pointer][1];
		}
		pathStack.push(a);

		return pathStack;

	}

	/**
	 * Creates a table for every node with its
	 * shortest known distance 
	 * previous vertex, keep track of the previous vertex that we came from
	 * @return
	 */
	private int[][] createTable() {
		
		visited = new boolean[adj.length];
		
		int[][] costTable = new int[adj.length][2];//a cost table will always have a column of shortest distance and previous vertex

		costTable[0][0] = 0;//initializing 0th index to 0

		for (int i = 0; i < costTable.length; i++) {
			costTable[i][0] = Integer.MAX_VALUE;//remaining with max value as infinite
		}

		setTable(0, costTable);//invoking recursive method to set values in this table
		return costTable;
	}

	/**
	 * Sets values in the table according to traversal
	 * Retrieves vertex with shortest distance from the unvisited neighboring nodes
	 * @param index, vertex to be explored
	 * @param costTable
	 */
	private void setTable(int index, int[][] costTable) {

		Iterator<Edge> itr = adj[index].listIterator();

		int cost = costTable[index][0];
		while (itr.hasNext()) {
			Edge e = itr.next();
			if (!visited[e.nodeId]) {
				int neighbourCost = cost + e.weight;//adds cost of the vertex in the weight of the edge
				if (neighbourCost < costTable[e.nodeId][0]) {//if it is less than shortest distance in the cost table then, update it with new cost  
					costTable[e.nodeId][0] = neighbourCost;//new cost
					costTable[e.nodeId][1] = index;//new previous vertex
				}
			}
		}
		visited[index] = true;//mark this index vertex as visited now

		if (isEveryNodeTraversed(visited)) {
			return;//if every vertex is visited recursion stops
		} else {//retrieving new vertex to be explored
			int min = getMinimumIndex(visited, costTable);//invoking get minimum to get a vertex having shortest distance of the unvisited nodes
			setTable(min, costTable);//RECURSIVE
		}
	}
	
	/**
	 * @param visited, keeps track of visited nodes so far
	 * @param costTable, keeps track of shortest known distance for every vertex
	 * @return a vertex having shortest distance of the unvisited nodes
	 */
	private int getMinimumIndex(boolean[] visited, int[][] costTable) {
		
		int min = Integer.MAX_VALUE;
		int index = 0;
		
		for (int i = 0; i < costTable.length; i++) {
			
			for (int j = 0; j < adj[i].size(); j++) {

				if (!visited[adj[i].get(j).nodeId] && min > costTable[adj[i].get(j).nodeId][0]) {

					min = costTable[adj[i].get(j).nodeId][0];
					index = adj[i].get(j).nodeId;
				}
			}
		}
		return index;
	}

}
