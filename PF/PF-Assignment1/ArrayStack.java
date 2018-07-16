package assignment1;

public class ArrayStack {
	static final int MAX = 1000;
	int top;
	int stackArray[] = new int[MAX];

//Check if stack is empty
	boolean isEmpty() {
		return (top < 0);
	}

//Initializes the "top"	
	ArrayStack() {
		top = -1;
	}

//Returns the top element from the stack
	int top() {
		return stackArray[top];
	}

//Pushes the item on the top of the stack.	
	boolean push(int item) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack overflow");
			return false;
		} else {
			stackArray[++top] = item;
			return true;
		}
	}

//Pops the item on the top of the stack	
	int pop() {
		if (top < 0) {
			System.out.println("Stack Undreflow. Nothing to Pop");
			return 0;
		} else {
			int item = stackArray[top--];
			return item;
		}
	}

	public static void main(String[] args) {
		ArrayStack s = new ArrayStack();
		s.push(25);
		s.pop();
		s.pop();
		s.push(45);
		System.out.println(s.top() + " is the top item ine the stack.");
		System.out.println("Stack is empty: " + s.isEmpty());
				
	}
}
