/**
 * Created a Node class that will create a node with
 * data, content in node
 * next, pointer to the next node
 */
class Node{
	int data;
	Node next;
	
	//Parameterized Constructor
	public Node(int item) {
		data = item;
		next = null;
	}
}