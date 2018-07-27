import static org.junit.Assert.*;
import org.junit.Test;

public class multiplyTest {

	
	// test case if after multiplying there are no terms common having same degree.
	@Test
	public void diffDegree(){
		Polynomial p1 = new Polynomial(new int[][]{{8,5},{5,1},{0,3}});
		Polynomial p2 = new Polynomial(new int[][]{{6,2},{2,8}});
		int[][] expectedResult = new int[][]{{14,10},{10,40},{11,2},{7,8},{6,6},{2,24}};
			
		assertArrayEquals(p1.multiply(p1,p2),expectedResult);
	}
	
	// test case if after multiplying there are some terms having same degree
	@Test
	public void sameDegree(){
		Polynomial p1 = new Polynomial(new int[][]{{8,5},{5,1},{0,3}});
		Polynomial p2 = new Polynomial(new int[][]{{5,2},{2,8}});
		int[][] expectedResult = new int[][]{{13,10},{10,42},{7,8},{5,6},{2,24}};
		
		assertArrayEquals(p1.multiply(p1,p2),expectedResult);
	}
	
	//Exception when a zero coefficient is traversed.
	@Test(expected = AssertionError.class)
	public void zeroCoefficient(){
		Polynomial p1 = new Polynomial(new int[][]{{8,5},{5,1},{0,3}});
		Polynomial p2 = new Polynomial(new int[][]{{5,2},{2,0}});
		int[][] expectedResult = new int[][]{{13,10},{10,42},{7,8},{5,6},{2,24}};
		
		assertArrayEquals(p1.multiply(p1,p2),expectedResult);
	}
	
}

