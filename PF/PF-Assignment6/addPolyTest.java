import static org.junit.Assert.*;

import org.junit.Test;

public class addPolyTest {

	// test case if there is no terms common having same degree.
	@Test
	public void diffDegree() {
		Polynomial p1 = new Polynomial(new int[][] { { 8, 5 }, { 5, 1 },
				{ 0, 3 } });
		Polynomial p2 = new Polynomial(new int[][] { { 6, 2 }, { 2, 8 } });
		int[][] expectedResult = new int[][] { { 8, 5 }, { 6, 2 }, { 5, 1 },
				{ 2, 8 }, { 0, 3 } };

		assertArrayEquals(p1.addPoly(p1, p2), expectedResult);
	}

	// test case if both polynomials contains a term of same degree.
	@Test
	public void sameDegree() {
		Polynomial p1 = new Polynomial(new int[][] { { 8, 5 }, { 5, 1 },
				{ 0, 3 } });
		Polynomial p2 = new Polynomial(new int[][] { { 5, 2 }, { 2, 8 } });
		int[][] expectedResult = new int[][] { { 8, 5 }, { 5, 3 }, { 2, 8 },
				{ 0, 3 } };

		assertArrayEquals(p1.addPoly(p1, p2), expectedResult);
	}

	// test case if all degrees are common in both polynomial.
	@Test
	public void allSameDegree() {
		Polynomial p1 = new Polynomial(new int[][] { { 8, 5 }, { 5, 1 },
				{ 0, 3 } });
		Polynomial p2 = new Polynomial(new int[][] { { 8, 5 }, { 5, 1 },
				{ 0, 3 } });
		int[][] expectedResult = new int[][] { { 8, 10 }, { 5, 2 }, { 0, 6 } };

		assertArrayEquals(p1.addPoly(p1, p2), expectedResult);
	}
	
	//Exception when a zero coefficient is traversed.
		@Test(expected = AssertionError.class)
		public void zeroCoefficient(){
			Polynomial p1 = new Polynomial(new int[][]{{8,5},{5,1},{0,3}});
			Polynomial p2 = new Polynomial(new int[][]{{5,2},{2,0}});
			int[][] expectedResult = new int[][]{{13,10},{10,42},{7,8},{5,6},{2,24}};
			
			assertArrayEquals(p1.addPoly(p1,p2),expectedResult);
		}

}
