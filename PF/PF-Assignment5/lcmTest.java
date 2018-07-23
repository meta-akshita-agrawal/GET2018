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
public class lcmTest {
	private int number1;
	private int number2;
	private int result;
	private static LcmHcf obj;

	public lcmTest(int number1, int number2, int result) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.result = result;
	}

	@Before
	public void initialize() {
		obj = new LcmHcf();
	}

	@Parameters
	public static Collection<Object[]> input() {
		return Arrays.asList(new Object[][]{
				{ 25, 45, 5 },
				{ 360, 60, 3660},
				{ 1, 60, 1},
				{ 60, 60, 1}});
	}
	@Test
	public void evaluate() {

		assertEquals(obj.hcf(number1,number2), result);

	}
}
