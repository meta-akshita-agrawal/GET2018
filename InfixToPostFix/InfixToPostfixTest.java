import static org.junit.Assert.*;

import org.junit.Test;

public class InfixToPostfixTest {
	
	@Test
	public void poisitiveEvaluation() {
		
		InfixToPostfix obj = new InfixToPostfix("A * ( B + C ) * D");
		String output = obj.changingToPostFix();
		
		assertEquals(output,"ABC+*D");
	}
	
	@Test
	public void negativeEvaluation() {
	
		InfixToPostfix obj = new InfixToPostfix("A * ( B + C ) * D");
		String output = obj.changingToPostFix();
		
		assertNotEquals(output,"ABC+D");
	}
	
	@Test
	public void whiteSpaceAtStart() {
		
		InfixToPostfix obj = new InfixToPostfix(" A * ( B + C ) * D");
		String output = obj.changingToPostFix();
		
		assertEquals(output,"ABC+*D");
	}
	
	@Test
	public void whiteSpaceAtEnd() {
		
		InfixToPostfix obj = new InfixToPostfix("A * ( B + C ) * D ");
		String output = obj.changingToPostFix();
		
		assertEquals(output,"ABC+*D");
	}
	
	@Test (expected = AssertionError.class)
	public void invalidExpression() {
		
		InfixToPostfix obj = new InfixToPostfix("A * ( B + C ) * ");
		obj.changingToPostFix();
		
	}
}
