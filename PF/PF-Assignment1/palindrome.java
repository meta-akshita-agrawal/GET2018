package assignment1;

import java.util.Scanner;
public class palindrome{
    
    static final int MAX=1000;
    int top;
    char stackArray[] = new char[MAX];
    
    //Check if stack is empty
	boolean isEmpty() {
		return (top < 0);
	}

//Initializes the "top"	
	palindrome() {
		top = -1;
	}


//Pushes the item on the top of the stack.	
	boolean push(char item) {
		if (top >= (MAX - 1)) {
			System.out.println("Stack overflow");
			return false;
		} else {
			stackArray[++top] = item;
			return true;
		}
	}

//Pops the item on the top of the stack	
	char pop() {
		if (top < 0) {
			System.out.println("Stack Undreflow. Nothing to Pop");
			return stackArray[top];
		} else {
			char item = stackArray[top--];
			System.out.println(item);
			return item;
		}
	}

    public static void main(String[] args) {
        
        palindrome stack = new palindrome();
    	
        Scanner input=new Scanner(System.in);
        System.out.println("Enter any string:");
        String inputString = input.nextLine();
        
        input.close();
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
            System.out.println(inputString.charAt(i));
        }
        

        String reverseString = "";

        while (!stack.isEmpty()) {
            reverseString = reverseString + stack.pop();
        }

        if (inputString.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");

    }
}