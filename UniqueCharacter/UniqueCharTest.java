import static org.junit.Assert.*;

import org.junit.Test;


public class UniqueCharTest {
	
	@Test
	public void positiveTestCase(){
		
		UniqueChar obj = new UniqueChar();
		
		int output1 = obj.numberOfUniChar("akshita");
		
		assertEquals(output1,5);
	}
	
	@Test
	public void negativeTestCase(){
		
		UniqueChar obj = new UniqueChar();
		
		int output1 = obj.numberOfUniChar("akshita");
		
		assertNotEquals(output1,3);
	}
	
	@Test(expected = AssertionError.class)
	public void testCaseWhenStringIsEmpty(){
		
		UniqueChar obj = new UniqueChar();
		
		obj.numberOfUniChar("");
	
	}
	
	@Test
	public void AllDuplicateCharacters(){
		
		UniqueChar obj = new UniqueChar();
		
		int output1 = obj.numberOfUniChar("aakk");
		
		assertEquals(output1,0);
	}
}