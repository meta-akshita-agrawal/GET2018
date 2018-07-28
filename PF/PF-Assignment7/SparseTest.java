

import static org.junit.Assert.*;

import org.junit.Test;

public class SparseTest {

	@Test
	public void testForTranspose() {
		int[][] input = new int[][] { { 1, 2, 10 }, { 1, 3, 12 }, { 2, 1, 1 }, { 2, 3, 2 } };
		Sparse s1 = new Sparse(input,4,4);
		int[][] output = new int[][] { { 1, 2, 1 }, { 2, 1, 10 }, { 3, 1, 12 }, { 3, 2, 2 } };
		
		assertArrayEquals(s1.transpose(),output);
	}
	
	@Test
	public void testForSymmetry() {
		int[][] input = new int[][] { { 0, 1, 10 }, { 1, 0, 10 } };
		Sparse s1 = new Sparse(input,4,4);
		
		assertEquals(s1.symmetry(),true);
	}
	
	@Test
	public void testForAdd() {
		int[][] arrayA = new int[][] { { 1, 2, 10 }, { 1, 3, 12 }, { 2, 1, 1 }, { 2, 3, 2 } };
		Sparse a = new Sparse(arrayA, 4, 4);

		int[][] arrayB = new int[][] { { 1, 1, 2 }, { 1, 3, 5 }, { 2, 1, 7 } };
		Sparse b = new Sparse(arrayB, 4, 4);
		
		int[][] arrayC = new int[][] { { 1, 1, 2 }, { 1, 2, 10 }, { 1, 3, 17 }, { 2, 1, 8 }, { 2, 3, 2 } };
		
		assertArrayEquals(a.add(b),arrayC);
	}
	
	@Test
	public void testForMultiply() {
		int[][] arrayA = new int[][] { { 1, 2, 10 }, { 1, 3, 12 }, { 2, 1, 1 }, { 2, 3, 2 } };
		Sparse a = new Sparse(arrayA, 4, 4);

		int[][] arrayB = new int[][] { { 1, 1, 2 }, { 1, 3, 5 }, { 2, 1, 7 } };
		Sparse b = new Sparse(arrayB, 4, 4);
		
		int[][] arrayC = new int[][] { { 1, 1, 70 }, { 2, 1, 2 }, { 2, 3, 5 } };
		
		assertArrayEquals(a.multiply(b),arrayC);
	}
	
	@Test(expected = AssertionError.class)
	public void testForUnsorted() {
		int[][] arrayA = new int[][] { { 1, 2, 10 }, { 1, 1, 12 }, { 2, 1, 1 }, { 2, 3, 2 } };
		Sparse a = new Sparse(arrayA, 4, 4);

		int[][] arrayB = new int[][] { { 1, 1, 2 }, { 1, 3, 5 }, { 2, 1, 7 } };
		Sparse b = new Sparse(arrayB, 4, 4);
		
		int[][] arrayC = new int[][] { { 1, 1, 70 }, { 2, 1, 2 }, { 2, 3, 5 } };
		
		assertArrayEquals(a.multiply(b),arrayC);
	}
}
