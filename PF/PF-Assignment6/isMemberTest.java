import static org.junit.Assert.*;

import org.junit.Test;

public class isMemberTest {

	@Test
	public void ordinary() {
		IntSet obj1 = new IntSet(new int[] { 3, 25, 67 });
		assertEquals(obj1.isMember(67), true);
	}

	@Test
	public void negative() {
		IntSet obj1 = new IntSet(new int[] { 3, 25, 67 });
		assertNotEquals(obj1.isMember(45), true);
	}

	//set should be sorted otherwise assertion error
	@Test(expected = AssertionError.class)
	public void notSorted() {
		new IntSet(new int[] { 100, 3, 25, 67 });
	}

	//set should not contain duplicates otherwise assertion error.
	@Test(expected = AssertionError.class)
	public void duplicates() {
		new IntSet(new int[] { 100, 100, 25, 67 });
	}

}
