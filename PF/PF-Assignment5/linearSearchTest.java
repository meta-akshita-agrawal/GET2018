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
public class linearSearchTest {
	private int[] sortedArray;
	private int key;
	private int index;
	private static Search obj;

	public linearSearchTest(int[] sortedArray,int key, int index) {
		super();
		this.sortedArray = sortedArray;
		this.key = key;
		this.index = index;
	}

	@Before
	public void initialize() {
		obj = new Search();
	}

	@Parameters
	public static Collection<Object[]> input() {
		return Arrays.asList(new Object[][]{
				{ new int[] {1,2,3,4,5}, 5, 4},
				{ new int[] {1,2,3,4,5}, 1, 0},
				{ new int[] {1,2,3,4,5}, 3, 2},
				{ new int[] {6,2,3,4,5}, 5, 4},
				{ new int[] {1,2,3,4,5}, 6, 3}});
	}
	@Test
	public void evaluate() {

		assertEquals(obj.linearCall(sortedArray,key), index);

	}
}
