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
public class fixXYTest {

	private int[] newArray;
	private int X;
	private int Y;
	private int[] result;
	private static ArrOperation obj;

	public fixXYTest(int[] newArray, int[] result, int X, int Y) {
		super();
		this.newArray = newArray;
		this.result = result;
		this.X = X;
		this.Y = Y;
	}

	@BeforeClass
	public static void initialize() {
		obj = new ArrOperation();
	}

	@Parameters
	public static Collection<Object[]> input() {
		return Arrays.asList(new Object[][] {
				{ new int[] { 5, 4, 9, 4, 9, 5 },new int[] { 9, 4, 5, 4, 5, 9 }, 4, 5 },
				{ new int[] { 1, 9, 1, 6 }, new int[] { 1, 9, 6, 1 }, 9, 6 },
				{ new int[] {}, new int[] {},4,5},
				{ new int[] { 1, 4, 1, 5, 5, 4, 1 },new int[] { 1, 4, 5, 1, 1, 4, 5 }, 4, 5 },
				{ new int[] { 1, 4, 4, 5, 5 }, new int[] { 1, 4, 5, 4, 5 }, 4, 5 },
				{ new int[] { 1, 4, 5, 5, 4 }, new int[] { 1, 4, 5, 4, 5 }, 4, 5},
				{ new int[] { 1, 4, 5, 4, 6 }, new int[] { 1, 4, 5, 4, 5 }, 4, 5},
				{ new int[] { 8, 9, 8, 9, 6 }, new int[] { 6, 9, 8, 9, 8 }, 9, 8}});
	}

	@Test
	public void evaluate() {

		assertArrayEquals(obj.fixMethod(newArray, X, Y), result);

	}
}
