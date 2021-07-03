public class StackArray implements Stack {

	int stackArray[];
	int arraySize;
	int top;

	// Parameterized constructor
	StackArray(int arraySize) {
		this.stackArray = new int[arraySize];
		this.arraySize = arraySize;
		top = -1;
	}

	/**
	 * Pops the item from the stack
	 * Just decrease top pointer
	 */
	public void pop() {
		if (top < 0) {
			throw new AssertionError("Stack Undreflow. Nothing to Pop");//throws error if there is nothing to pop
		} else {
			top--;
		}

	}

	/**
	 * Pushes the item in the stack
	 * increase top pointer and add item in it
	 * @param item to push
	 */
	public void push(int item) {
		if (top >= (arraySize - 1)) {
			throw new AssertionError("Stack overflow");//throws error if stack is full
		} else {
			stackArray[++top] = item;
		}
	}

	/**
	 * Checks if stack is empty
	 */
	public boolean isEmpty() {
		return (top < 0);
	}

	/**
	 * @return stack array
	 */
	public int[] getStack() {
		int[] stack = new int[top + 1];

		for (int i = 0; i < stack.length; i++) {
			stack[i] = this.stackArray[i];
		}

		return stack;
	}

}