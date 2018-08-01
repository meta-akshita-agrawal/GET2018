
public class StackList implements Stack{

	Node top;
	
	StackList(){
		top= null;
	}
	
	public boolean isEmpty() {
		if(top==null) {
			return true;
		}
		else
			return false;
	}	
	
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
	
	public void pop() {
		if (isEmpty()==true) {
			System.out.println("Stack is empty. Nothing to pop.");
		}
		else {
			top = top.next;
		}
	}
	
	public int top() {
		if(isEmpty()==true) {
			System.out.println("Stack is empty.");
			return -1;
		}
		else {
			return top.data;
		}
	}


	
}
