

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseTest {

	//Test for transpose method
	@Test
	public void testForTransposePositive() {

		int[][] input = new int[][] { { 1, 2, 10 }, { 1, 3, 12 }, { 2, 1, 1 }, { 2, 3, 2 } };//expectedArray

		int[][] output = new int[][] { { 1, 2, 1 }, { 2, 1, 10 }, { 3, 1, 12 }, { 3, 2, 2 } };//actualArray

		SparseMatrix s1 = new SparseMatrix(input,4,4);
		
		assertArrayEquals(s1.transpose(),output);
	}
	
	//Test for symmetry method
	@Test
	public void testForSymmetry() {
		int[][] input = new int[][] { { 0, 1, 10 }, { 1, 0, 10 } };
		
		SparseMatrix s1 = new SparseMatrix(input,4,4);
		
		assertEquals(s1.symmetry(),true);
	}
	
	//Test for add method
	@Test
	public void testForAdd() {
		int[][] arrayA = new int[][] { { 1, 2, 10 }, { 1, 3, 12 }, { 2, 1, 1 }, { 2, 3, 2 } };
		SparseMatrix a = new SparseMatrix(arrayA, 4, 4);

		int[][] arrayB = new int[][] { { 1, 1, 2 }, { 1, 3, 5 }, { 2, 1, 7 } };
		SparseMatrix b = new SparseMatrix(arrayB, 4, 4);
		
		int[][] arraySum = new int[][] { { 1, 1, 2 }, { 1, 2, 10 }, { 1, 3, 17 }, { 2, 1, 8 }, { 2, 3, 2 } };
		
		assertArrayEquals(a.add(b),arraySum);
	}
	
	//Test for multiply method
	@Test
	public void testForMultiply() {
		int[][] arrayA = new int[][] { { 1, 2, 10 }, { 1, 3, 12 }, { 2, 1, 1 }, { 2, 3, 2 } };
		SparseMatrix a = new SparseMatrix(arrayA, 4, 4);

		int[][] arrayB = new int[][] { { 1, 1, 2 }, { 1, 3, 5 }, { 2, 1, 7 } };
		SparseMatrix b = new SparseMatrix(arrayB, 4, 4);
		
		int[][] arraySum = new int[][] { { 1, 1, 70 }, { 2, 1, 2 }, { 2, 3, 5 } };
		
		assertArrayEquals(a.multiply(b),arraySum);
	}
	
	//test for a unsorted matrix
	// Note that sparse matrix is always sorted
	@Test(expected = AssertionError.class)
	public void testForUnsorted() {
		int[][] arrayA = new int[][] { { 1, 2, 10 }, { 1, 1, 12 }, { 2, 1, 1 }, { 2, 3, 2 } };
		SparseMatrix a = new SparseMatrix(arrayA, 4, 4);

		int[][] arrayB = new int[][] { { 1, 1, 2 }, { 1, 3, 5 }, { 2, 1, 7 } };
		SparseMatrix b = new SparseMatrix(arrayB, 4, 4);
		
		int[][] arraySum = new int[][] { { 1, 1, 70 }, { 2, 1, 2 }, { 2, 3, 5 } };
		
		assertArrayEquals(a.multiply(b),arraySum);
	}
	
	//test for empty array
	@Test(expected = AssertionError.class)
	public void testForEmptyArray() {
		
		int[][] array = new int[0][0];
		SparseMatrix a = new SparseMatrix(array,5,5);
		
	}
	
	//adds 2 matrices both row filled
	@Test
	public void testForRowFilled() {
		int[][] arrayA = new int[][] { { 1, 0, 10 }, { 1, 1, 12 }, { 1, 2, 1 }, { 1, 3, 2 } };
		SparseMatrix a = new SparseMatrix(arrayA, 4, 4);

		int[][] arrayB = new int[][] { { 1, 0, 2 }, { 1, 1, 5 }, { 1, 2, 7 } , {1, 3, 8}};
		SparseMatrix b = new SparseMatrix(arrayB, 4, 4);
		
		int[][] arraySum = new int[][] { { 1, 0, 12 }, { 1, 1, 17 }, { 1, 2, 8 }, { 1, 3, 10 }};
		
		assertArrayEquals(a.add(b),arraySum);
	}
	
	//adds 2 matrices both column filled
		@Test
		public void testForColFilled() {
			int[][] arrayA = new int[][] { { 0, 0, 10 }, { 1, 0, 12 }, { 2, 0, 1 }, { 3, 0, 2 } };
			SparseMatrix a = new SparseMatrix(arrayA, 4, 4);

			int[][] arrayB = new int[][] {{0, 0, 2 }, { 1, 0, 5 }, { 2, 0, 7 } , {3, 0, 8}};
			SparseMatrix b = new SparseMatrix(arrayB, 4, 4);
			
			int[][] arraySum = new int[][] { { 0, 0, 12 }, { 1, 0, 17 }, { 2, 0, 8 }, { 3, 0, 10 }};
			
			assertArrayEquals(a.add(b),arraySum);
		}
}
