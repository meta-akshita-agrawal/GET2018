package testingAssignment;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class maxMirrorTest {

	private int[] newArray;
	private int result;
	private static ArrOperation obj;

	public maxMirrorTest(int[] newArray, int result) {
		super();
		this.newArray = newArray;
		this.result = result;
	}

	@BeforeClass
	public static void initialize() {
		obj = new ArrOperation();
	}

	@Parameters
	public static Collection<Object[]> input() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 1, 2, 3, 8, 9, 3, 2, 1}, 3 },
				{ new int[] { 7, 1, 4, 9, 7, 4, 1 }, 2 },
				{ new int[] { 1, 4, 5, 3, 5, 4, 1 }, 7 },
				{ new int[] { 1, 2, 1, 4 }, 3 }, 
				{ new int[] { 1 , 2 , 3, 1 }, 1},
				{ new int[] {}, 0},
				{ new int[] {1, 2, 3, 8, 9, 3, 2, 1, 9, 8, 3},3},
				{ new int[] {1, 2, 3, 8, 9, 3, 2, 9, 8, 3},4},
				{ new int[] {1, 2, 3, 8, 9, 3, 2, 3, 9, 8, 3},9},
				{ new int[] {1, 2, 3, 8, 9, 3, 2, 4, 3, 9, 8, 3},4}});

	}

	@Test
	public void evaluate() {
		assertEquals(obj.maximumMirror(newArray), result);
	}
}
