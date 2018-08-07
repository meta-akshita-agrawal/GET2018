public class QueueArray implements CircularQueue {

	private int[] array;
	private int arraySize;
	private int front;
	private int rear;

	// Parameterized constructor
	QueueArray(int arraySize) {
		array = new int[arraySize];
		this.arraySize = arraySize;
		this.front = -1;
		this.rear = front;
		//System.out.println(rear);
	}

	/**
	 * checks if queue is empty
	 */
	public boolean isEmpty() {
		return (front == -1);
	}

	/**
	 * Adds an item to the last of queue
	 */
	public void enqueue(int item) {

		if (rear+1 == front ) {
			throw new AssertionError("Array is full");//throws error if queue is full
		}
		
		if(rear== front && front == -1){
			this.array[rear+1] = item;
			front++;
			rear++;
		}
		
		else{
			this.array[rear+1] = item;//adding item at rear
			//System.out.println(front + " " +( rear + 1) + " " + array[rear+1]);
			rear++;
		}
		if(rear == arraySize-1){
			rear = -1;
		}
		
		
	}

	/**
	 * Removing item from start of the queue
	 * Shift others towards front
	 */
	public void dequeue() {

		if (isEmpty()) {
			throw new AssertionError("Array is empty nothing to dequeue");//throw error if empty
		}
		front++;
	}

	/**
	 * @return queue with alloted items only
	 */
	public int[] getQueue() {
		
		int length = (rear - front) + 1;
		int queueSize  = 0;
		
		if(length > 0) {
			queueSize = length;
		}
		else {
			rear = arraySize + rear;
			queueSize = Math.abs(front - rear) + 1;
		}
	
		int[] queue = new int[queueSize];
		for (int i = 0; i < queue.length; i++) {
			queue[i] = this.array[i];
		}
		return queue;
	}

}