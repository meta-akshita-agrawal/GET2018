
public class StackArray implements Stack {

	static final int MAX = 1000;
	int stackArray[] = new int[MAX];

	int top;

	// Initializes the "top"
	StackArray() {
		top = -1;
	}

	@Override
	public void pop() {
		if (top < 0) {
			System.out.println("Stack Undreflow. Nothing to Pop");
		} else {
			top--;
		}

	}

	@Override
	public void push(int item) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack overflow");
		} else {
			stackArray[++top] = item;
		}
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public int top() {
		return stackArray[top];
	}

}
