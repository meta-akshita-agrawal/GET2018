public interface CircularQueue {

	boolean isEmpty();//checks if queue is empty

	void enqueue(int item);//adds an item at the last of queue

	void dequeue();//removes an item from the front of queue

	int[] getQueue();//returns queue 
	
}