
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public interface UndirectedWeighted {

	boolean isConnected(); //Checks if a graph is connected i.e.: every node should have at least one edge

	LinkedList<Integer> reachable(int vertex); // Returns a path of vertices from vertex

	HashMap<Integer, Edge> mst(); // returns a list of minimum spanning tree

	Stack<Integer> shorestPath(int a, int b); // returns a path using Dijkstra's algorithm
}
