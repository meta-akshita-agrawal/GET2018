import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluationTest {
	
	
	@Test
	public void positiveEvaluation() {
		
		String input = "2 3 1 * + 9 -";
		PostFixEvaluation obj = new PostFixEvaluation(input);
		
 		int result = obj.evaluate();
		
 		assertEquals(result,-4);
	}
	
	@Test
	public void negativeEvaluation() {
		
		String input = "2 3 1 * + 9 -";
		PostFixEvaluation obj = new PostFixEvaluation(input);
		
 		int result = obj.evaluate();
		
 		assertNotEquals(result,25);
	}
	
	@Test
	public void whiteSpaceAtLastPosition() {
	
		String input = "2 3 1 * + 9 - ";
		PostFixEvaluation obj = new PostFixEvaluation(input);
		
 		int result = obj.evaluate();
		
 		assertEquals(result,-4);
	}
	
	@Test(expected=AssertionError.class)
	public void operatorAtStart() {
		
		String input = "+ 2 3 1 ";
		PostFixEvaluation obj = new PostFixEvaluation(input);
		
		obj.evaluate();
	}
	
	@Test(expected=AssertionError.class)
	public void noOperator() {
		String input = "2 3 1 ";
		PostFixEvaluation obj = new PostFixEvaluation(input);
		
 		int result = obj.evaluate();
		
 		assertEquals(result,-4);
	}
}
