public class QueueArray implements Queue {

	private int[] array;
	private int arraySize;
	private int front;
	private int rear;

	// Parameterized constructor
	QueueArray(int arraySize) {
		array = new int[arraySize];
		this.arraySize = arraySize;
		this.front = 0;
		this.rear = 0;
	}

	/**
	 * checks if queue is empty
	 */
	public boolean isEmpty() {
		return (rear == 0);
	}

	/**
	 * Adds an item to the last of queue
	 */
	public void enqueue(int item) {

		if (rear == arraySize) {
			throw new AssertionError("Array is full");//throws error if queue is full
		}

		this.array[rear] = item;//adding item at rear
		rear++;
	}

	/**
	 * Removing item from start of the queue
	 * Shift others towards front
	 */
	public void dequeue() {

		if (isEmpty()) {
			throw new AssertionError("Array is empty nothing to dequeue");//throw error if empty
		}

		for (int i = front; i < rear; i++) {
			this.array[i] = this.array[i + 1];
		}
		rear--;
	}

	/**
	 * @return queue with alloted items only
	 */
	public int[] getQueue() {
		int[] queue = new int[rear];
		for (int i = 0; i < queue.length; i++) {
			queue[i] = this.array[i];
		}
		return queue;
	}

}
