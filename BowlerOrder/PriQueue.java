
public class PriQueue implements PriorityQueue {

	int queueSize;
	Item[] queueArray;

	/**
	 * Constructor initializing an queue with queue size + 1;
	 * @param queueSize
	 */
	PriQueue(int queueSize) {
		this.queueSize = queueSize;
		queueArray = new Item[queueSize + 1];
	}

	int counter = 1;//counter to keep trace how many items are added in the array

	/**
	 * Adds an item in the queue
	 * Uses heap sort to add
	 * @param Item to be added
	 */
	public void add(Item item) {
		
		if(counter == queueSize+1) {
			throw new AssertionError("Queue Overflow");
		}

		queueArray[counter] = item;//adds the item in the array

		if (counter == 1) {//if first item is added simply return
			counter++;
			return;
		}

		//sorting the heap tree according to priorities
		
		int pointer = counter; 
		int parentPointer = pointer / 2;//parentPointer will always be pointer divided by 2

		//loops until first node is traversed or priority of parent is less than child
		while (pointer != 1 && queueArray[pointer].getPriority() > queueArray[parentPointer].getPriority()) {
																											
			swap(queueArray[pointer], queueArray[parentPointer]);//swapping parent and child
			pointer = parentPointer;
			parentPointer = parentPointer / 2;	//updation of pointers
		}
		counter++;
	}

	
	/**
	 * Removes an item from the queue
	 * Root will be removed
	 */
	public void remove() {
		
		if(counter == 0) {
			throw new AssertionError("Nothing to remove");
		}

		queueArray[1] = queueArray[counter - 1];//Changing root to last item in the heap
		counter--; // Updating counter to 1 less as one item is removed

		Item leftChild = queueArray[2];
		Item rightChild = queueArray[3];

		//this child-Parent difference is used to get parent index as we have to
		// add 1 if child is right i.e. : 2 * childIndex + 1
		// for left child it will be simply 2 * childIndex
		int childParentDiff = (leftChild.getPriority() > rightChild.getPriority()) ? 0 : 1;
		

		int pointer = 1;
		
		int childPointer = (2 * pointer) + childParentDiff;//setting child pointer with parent Pointer 

		//loops until parent child pointer reaches to last level
		while (childPointer != counter && queueArray[pointer].getPriority() < queueArray[childPointer].getPriority()) {

			swap(queueArray[pointer], queueArray[childPointer]);

			pointer = childPointer;
			childPointer = (2 * childPointer) + childParentDiff;
		}

	}

	/**
	 * @return front of the queue or highest priority item 
	 */
	@Override
	public Item peek() {
		return queueArray[1];
	}

	/**
	 * Used for swapping a and b items contents
	 * @param a
	 * @param b
	 */
	private void swap(Item a, Item b) {
		String tempName = a.name;
		a.name = b.name;
		b.name = tempName;

		int tempPri = a.priority;
		a.priority = b.priority;
		b.priority = tempPri;
	}

	/**
	 * @return returns priority queue
	 */
	public Item[] getQueueArray() {
		return queueArray;
	}

}
