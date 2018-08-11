import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

	WeightedGraph wg = new WeightedGraph(5);

	@Before
	public void initialize() {

		wg.addEdge(0, new Edge(1, 3));
		wg.addEdge(0, new Edge(2, 6));
		wg.addEdge(0, new Edge(4, 5));
		wg.addEdge(1, new Edge(0, 3));
		wg.addEdge(1, new Edge(3, 4));
		wg.addEdge(1, new Edge(2, 2));
		wg.addEdge(2, new Edge(0, 6));
		wg.addEdge(2, new Edge(1, 2));
		wg.addEdge(2, new Edge(3, 2));
		wg.addEdge(3, new Edge(1, 4));
		wg.addEdge(3, new Edge(2, 2));
		wg.addEdge(4, new Edge(0, 5));
	}

	@Test
	public void testForConnected() {

		assertEquals(wg.isConnected(), true);
	}

	@Test
	public void testForDisconnected() {

		WeightedGraph wg = new WeightedGraph(5);

		wg.addEdge(0, new Edge(1, 3));
		wg.addEdge(0, new Edge(2, 6));
		// wg.addEdge(0, new Edge(4,5)); disconnected edge
		wg.addEdge(1, new Edge(0, 3));
		wg.addEdge(1, new Edge(3, 4));
		wg.addEdge(1, new Edge(2, 2));
		wg.addEdge(2, new Edge(0, 6));
		wg.addEdge(2, new Edge(1, 2));
		wg.addEdge(2, new Edge(3, 2));
		wg.addEdge(3, new Edge(1, 4));
		wg.addEdge(3, new Edge(2, 2));
		// wg.addEdge(4, new Edge(0,5));

		assertNotEquals(wg.isConnected(), true);
	}

	@Test
	public void reachableTest() {

		LinkedList<Integer> expectedReachableNodes = new LinkedList<>();
		expectedReachableNodes.add(0);
		expectedReachableNodes.add(3);
		expectedReachableNodes.add(2);

		LinkedList<Integer> actualReachableNodes = wg.reachable(1);

		for (int i = 0; i < actualReachableNodes.size(); i++) {
			assertEquals(expectedReachableNodes.get(i), actualReachableNodes.get(i));
		}
	}

	@Test
	public void negativeReachableTest() {

		LinkedList<Integer> expectedReachableNodes = new LinkedList<>();
		expectedReachableNodes.add(4);
		expectedReachableNodes.add(2);
		expectedReachableNodes.add(1);

		LinkedList<Integer> actualReachableNodes = wg.reachable(1);

		for (int i = 0; i < actualReachableNodes.size(); i++) {
			assertNotEquals(expectedReachableNodes.get(i), actualReachableNodes.get(i));
		}
	}

	@Test
	public void mstTest() {

		HashMap<Integer, Edge> expectedMst = new HashMap<>();
		expectedMst.put(1, new Edge(0, 3));
		expectedMst.put(2, new Edge(1, 2));
		expectedMst.put(3, new Edge(2, 2));
		expectedMst.put(4, new Edge(0, 5));

		HashMap<Integer, Edge> actualMst = wg.mst();

		for (int i : actualMst.keySet()) {
			assertEquals(actualMst.get(i).nodeId, expectedMst.get(i).nodeId);
		}

	}

	@Test
	public void negativeMstTest() {

		LinkedList<EdgeWithSourceDest> expectedMst = new LinkedList<>();
		expectedMst.add(new EdgeWithSourceDest(0, 1, 3));
		expectedMst.add(new EdgeWithSourceDest(1, 2, 2));
		expectedMst.add(new EdgeWithSourceDest(2, 2, 3));
		expectedMst.add(new EdgeWithSourceDest(0, 4, 5));

		HashMap<Integer, Edge> actualMst = wg.mst();

		for (int i = 0; i < expectedMst.size(); i++) {
			assertNotEquals(expectedMst.get(i), actualMst.get(i));
		}
	}

	@Test
	public void shortestPathTest() {

		Stack<Integer> expectedStack = new Stack<>();
		expectedStack.push(2);
		expectedStack.push(1);
		expectedStack.push(0);

		Stack<Integer> actualStack = wg.shorestPath(0, 2);

		for (int i = 0; i < actualStack.size(); i++) {
			assertEquals(actualStack.pop(), expectedStack.pop());
		}
	}

	@Test
	public void negativeShortestPathTest() {

		Stack<Integer> expectedStack = new Stack<>();
		expectedStack.push(6);
		expectedStack.push(3);
		expectedStack.push(1);

		Stack<Integer> actualStack = wg.shorestPath(0, 2);

		for (int i = 0; i < actualStack.size(); i++) {
			assertNotEquals(actualStack.pop(), expectedStack.pop());
		}
	}
}
