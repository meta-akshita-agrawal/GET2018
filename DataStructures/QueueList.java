public class QueueList implements Queue {

	Node front;
	Node rear;

	//Constructor
	QueueList() {
		this.front = null;
		this.rear = null;
	}

	/**
	 * Checks if a queue is empty
	 */
	public boolean isEmpty() {
		return this.rear == null;
	}

	/**
	 * Adds a node at the end of linked list
	 * @param item to add
	 */
	public void enqueue(int item) {

		Node newNode = new Node(item);

		if (front == null) {//if queue is empty both front and end will be set to new node
			this.front = newNode;
			this.rear = newNode;
		} else {
			rear.next = newNode;//adding new node to next of rear
			rear = newNode;//updating rear
		}

	}

	/**
	 * removes a node from start of linked list
	 */
	public void dequeue() {

		if (isEmpty()) {
			throw new AssertionError("queue is empty. nothing to dequeue");
		}

		front = front.next;//updates front

	}

	/**
	 * evaluates number of nodes
	 * @return
	 */
	private int listSize() {
		int counter = 0;
		Node rear = front;
		while (rear != null) {
			rear = rear.next;
			counter++;
		}
		return counter;
	}

	/**
	 * @return queue with nodes size
	 */
	public int[] getQueue() {
		int listSize = listSize();
		int[] queue = new int[listSize];
		Node rear = this.front;
		for (int i = 0; i < queue.length; i++) {
			queue[i] = rear.data;
			rear = rear.next;
		}
		return queue;
	}

}
