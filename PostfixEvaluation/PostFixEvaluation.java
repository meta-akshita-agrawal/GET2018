
public class PostFixEvaluation {

	String inputExpression;//expression to perform evaluation

	//Parameterized Constructor
	PostFixEvaluation(String inputExpression) {
		this.inputExpression = inputExpression;
	}

	/**
	 * Parse an input string, which should contain tokens spaced with white space
	 * @return an array of tokens containing operands and operators
	 */
	private Character[] parseExpression() {
		
		int flag = 0; //flag to check presence of at least one operator

		String[] str = this.inputExpression.split(" ");//splits according to white spaces
		Character[] tokens = new Character[str.length];
		
		for (int i = 0; i < tokens.length; i++) {
			tokens[i] = str[i].charAt(0);
			if(checkOperator(tokens[i])) {
				flag = 1;
			}
		}
		
		if(checkOperator(tokens[0])) {
			throw new AssertionError("Invalid expression");//throw error if a operator is at the beginning of an expression
		}
		
		if(flag==0) {
			throw new AssertionError("No operator Found in the Expression.");//throw error if there is no operator in the expression
		}
		

		return tokens;
	}
	
	/**
	 * Checks a character is a operator or not
	 * @param token, character to compare
	 * @return true if it is operator else false
	 */
	private boolean checkOperator(char token) {
		
		return token == '+' || token == '-' || token == '*' || token == '/'; 
	}

	/**
	 * Evaluates arithmetic operations on expression
	 * If the token is an operand, pushed in the stack
	 * If the token is an operator, 2 operands are popped and operation is performed on them
	 * and their result is pushed
	 * E.g.: + is traversed then 2 items a and b will be added, a+b  
	 * @return
	 */
	public int evaluate() {

		StackList stack = new StackList();

		Character[] tokens = parseExpression();

		for (int i = 0; i < tokens.length; i++) {

			if (Character.isDigit(tokens[i])) {
				stack.push(tokens[i] - '0');
			}

			else {

				int val1 = stack.pop();
				int val2 = stack.pop();

				switch (tokens[i]) {
				case '+':
					stack.push(val2 + val1);
					break;

				case '-':
					stack.push(val2 - val1);
					break;

				case '/':
					stack.push(val2 / val1);
					break;

				case '*':
					stack.push(val2 * val1);
					break;
				}

			}
		}
		return stack.pop();
	}

}
