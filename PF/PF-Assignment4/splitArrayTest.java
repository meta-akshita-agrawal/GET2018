package testingAssignment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class splitArrayTest {

	private int[] newArray;
	private int result;
	private static ArrOperation obj;

	public splitArrayTest(int[] newArray, int result) {
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
				{ new int[] {1, 1, 1, 2, 1}, 3 },
				{ new int[] { 2, 1, 1, 2, 1 }, -1 },
				{ new int[] {}, 0},
				{ new int[] { 10, 10 }, 1 },
				{ new int[] { 1, 2, 1 }, -1 },
				{ new int[] { 1, 1, 1, 0, 2, 1}, 3},
				{ new int[] { 0, 0}, 1}});

	}

	@Test
	public void evaluate() {

		assertEquals(obj.splitSum(newArray), result);

	}
}
