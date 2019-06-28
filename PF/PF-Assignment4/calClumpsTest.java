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
public class calClumpsTest {

	private int[] newArray;
	private int result;
	private static ArrOperation obj;

	public calClumpsTest(int[] newArray, int result) {
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
				{ new int[] { 1, 1, 2, 1, 1 }, 2 },
				{ new int[] { 1, 2, 2, 3, 4, 4 }, 2 },
				{ new int[] { 1, 1, 1, 1, 1 }, 1 } ,
				{ new int[] { 1, 2, 3, 4, 5 }, 0 } ,
				{ new int[] {}, 0},
 				{ new int[] { 2, 2, 3, 3, 3 }, 2 } });

	}

	@Test
	public void evaluate() {

		assertEquals(obj.calClumps(newArray), result);

	}

}
