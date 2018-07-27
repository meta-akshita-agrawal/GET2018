import static org.junit.Assert.*;

import org.junit.Test;

public class evaluateTest {

	// Ordinary test taking value of x as 1.00
	@Test
	public void ordinary() {
		Polynomial p1 = new Polynomial(new int[][] { { 8, 5 }, { 5, 1 },
				{ 0, 3 } });
		double x = 1.00;
		double expectedResult = 9.00;

		assertEquals(p1.evaluate(x), expectedResult, 0.01);
	}

	// Negative test case where output should be 8.00 but taken as 9.00
	@Test
	public void negative() {
		Polynomial p1 = new Polynomial(new int[][] { { 8, 5 }, { 0, 3 } });
		double x = 1.00;
		double expectedResult = 9.00;

		assertNotEquals(p1.evaluate(x), expectedResult, 0.01);
	}

	// test case if 0 is taken as x
	@Test
	public void zero() {
		Polynomial p1 = new Polynomial(new int[][] { { 8, 5 }, { 5, 1 },
				{ 0, 3 } });
		double x = 0.00;
		double expectedResult = 3.00;

		assertEquals(p1.evaluate(x), expectedResult, 0.01);
	}
	
	//Exception when a zero coefficient is traversed.
		@Test(expected = AssertionError.class)
		public void zeroCoefficient(){
			Polynomial p1 = new Polynomial(new int[][]{{8,5},{5,0},{0,3}});
			
			double x = 0.00;
			double expectedResult = 3.00;
			
			assertEquals(p1.evaluate(x),expectedResult,0.01);
		}

}
