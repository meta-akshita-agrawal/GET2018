public interface Stack {

	String pop();//pops the top element in a stack

	void push(String item);//pushes item in the stack

	boolean isEmpty();//checks if a stack is empty

	String[] getStack();//returns items of stack
	
	String top();//returns top of the stack
}