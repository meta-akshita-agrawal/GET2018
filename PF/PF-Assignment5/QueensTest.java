package recursionAssignment;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class QueensTest {
	private int boardSize;
	private int[][] result;
	private static Queens obj;

	public QueensTest(int boardSize, int[][] result) {
		super();
		this.boardSize = boardSize;
		this.result = result;
	}

	@Before
	public void initialize() {
		obj = new Queens();
	}

	@Parameters
	public static Collection<Object[]> input() {
		return Arrays.asList(new Object[][]{
				{ 6, new int[][]{{0, 0, 0, 1, 0,  0}, 
						 		 {1, 0, 0, 0, 0,  0}, 
						 		 {0, 0, 0, 0, 1,  0}, 
						 		 {0, 1, 0, 0, 0,  0}, 
						 		 {0, 0, 0, 0, 0,  1}, 
						 		 {0, 0, 1, 0, 0,  0}}},
				{ 4, new int[][]{ {0,  0,  1,  0}, 
						 		  {1,  0,  0,  0}, 
						 		  {0,  0,  0,  1}, 
						 		  {0,  1,  0,  0}}},
				{ 3, new int[][]{ {0,  0,  1,  0}, 
								  {1,  0,  0,  0}, 
								  {0,  0,  0,  1}, 
								  {0,  1,  0,  0},
}}});
	}
	@Test
	public void evaluate() {

		assertArrayEquals(obj.solveNQ(boardSize),result);
	}
	
	
}
