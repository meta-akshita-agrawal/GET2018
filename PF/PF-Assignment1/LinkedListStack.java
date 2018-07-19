package assignment1;

public class LinkedListStack {
	class Node{
		int data;
		Node next;
		public Node(int item) {
			data = item;
			next = null;
		}
	}
	
	Node top= null;
	
	//Check whether stack is empty.
	public boolean isEmpty() {
		return top == null;
	}	
	
	//Pushes item at the top stack
	public void push(int item) {
		if(isEmpty()==true) {
			Node p = new Node(item);
			top = p;
		}
		else {
			Node p = new Node(item);
			p.next = top;
			top = p;
		}
	}
	
	//Pops the item at the top of stack.
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty. Nothing to pop.");
			return -1;
		}
		else {
			int item = top.data;
			top = top.next;
			return item;
		}
	}
	
	//Returns the element at the top of the stack.
	public int top() {
		if(isEmpty()==true) {
			System.out.println("Stack is empty.");
			return -1;
		}
		else {
			return top.data;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack s = new LinkedListStack();
		s.push(25);
		s.pop();
		s.pop();
		s.push(45);
		System.out.println(s.top() + " is the top item ine the stack.");
		System.out.println("Stack is empty: " + s.isEmpty());
	}

}
