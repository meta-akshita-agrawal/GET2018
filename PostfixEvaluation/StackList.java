public class StackList implements Stack {

	Node top;

	//constructor
	StackList() {
		top = null;
	}

	/**
	 * Checks if stack is empty
	 */
	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else
			return false;
	}

	/**
	 * Pushes the item in the stack
	 * Creates a node p with data item in it
	 * @param item to push
	 */
	public void push(int item) {
		if (isEmpty() == true) {
			Node p = new Node(item);
			top = p; //simply updating top with new node p
		} else {
			Node p = new Node(item);
			p.next = top; //updating pointer of new node to top
			top = p;
		}
	}

	/**
	 * Pops the top item from stack
	 * change top to next pointer of top
	 */
	public int pop() {
		int temp;
		if (isEmpty() == true) {
			throw new AssertionError("Stack is empty. Nothing to pop.");//throws error if nothing to pop
		} else {
			temp = top.data;
			top = top.next;
		}
		return temp;
	}

	/**
	 * evaluates number of nodes in the list
	 * @return size of list
	 */
	public int getSize() {
		int counter = 0;
		Node pointer = top;
		while (pointer != null) {
			pointer = pointer.next;
			counter++;
		}
		return counter;
	}

	/**
	 * adds each node data to an array
	 * @return stack, array created 
	 */
	public int[] getStack() {
		int size = getSize();//adding size as number of nodes in the list
		int[] stack = new int[size];

		Node pointer = top;

		for (int i = 0; i < stack.length; i++) {//nodes added from top to last element
			stack[i] = pointer.data;
			pointer = pointer.next;
		}

		return stack;
	}

}