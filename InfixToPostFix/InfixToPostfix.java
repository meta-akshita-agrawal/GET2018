
public class InfixToPostfix {
	
	
	String infixExpression;
	
	InfixToPostfix(String infixExpression){
		this.infixExpression = infixExpression;
	}

	/**
	 * Returns Precedence of an operator according to java rules
	 * @param operator
	 * @return precedence of an operator
	 */
	public int precedence(String operator) {
		switch(operator) {
		
		case "!":
			return 7;
		case "*":
		case "/":
			return 6;
		case "+":
		case "-":
			return 5;
		case "<":
		case "<=":
		case ">":
		case ">=":
			return 4;
		case "!=":
		case "==":
			return 3;
		case "&&":
			return 2;
		case "||":
			return 1;
		default:
			return 0;
		}
	}
	
	/**
	 * Parse an expression to tokens
	 * @param expression, which is spaced by white spaces
	 * @return an array, of string tokens
	 */
	public String[] parser() {
		
		String[] tokens = this.infixExpression.split(" ");
		return tokens;
	}
	
	/**
	 * Changes an infix expression to postfix expression
	 * @param expression
	 * @return postfix expression
	 */
	public String changingToPostFix() {
	
		StackList stack = new StackList();
		
		String resultPostfix = "";
		String[] tokens = parser();
		
		for(int i=0;i<tokens.length;i++) {
			
			//System.out.println("---->" + tokens[i]);
			
			
			 // If the scanned character is an operand, add it to output.
            if (Character.isLetter(tokens[i].charAt(0)))
                resultPostfix += tokens[i];
              
            // If the scanned character is an '(', push it to the stack.
            else if (tokens[i] == "(")
                stack.push(tokens[i]);
             
            //  If the scanned character is an ')', pop and output from the stack 
            // until an '(' is encountered.
            else if (tokens[i] == ")")
            {
                while (!stack.isEmpty() && stack.top() != "(")
                    resultPostfix += stack.pop();
                 
                if (!stack.isEmpty() && stack.top() != "(")
                    throw new AssertionError("Invalid Expression"); // invalid expression                
                else
                    stack.pop();
            }
            else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(tokens[i]) <= precedence(stack.top()))
                    resultPostfix += stack.pop();
                stack.push(tokens[i]);
            }
            
            System.out.println(resultPostfix);
		}
		
		// pop all the operators from the stack
        while (!stack.isEmpty())
            resultPostfix += stack.pop();
      
        return resultPostfix;
	}
	
}
