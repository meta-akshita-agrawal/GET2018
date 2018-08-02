import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class StackTest {

	// test for pushing item in stack array
	@Test
	public void pushArrayTestPositive() {
		StackArray arrayObj = new StackArray(5);

		arrayObj.push(5);
		arrayObj.push(56);
		arrayObj.push(25);

		int[] expectedArray = arrayObj.getStack();

		int[] actualArray = new int[] { 5, 56, 25 };

		assertArrayEquals(expectedArray, actualArray);

	}

	// test for popping item in stack array
	@Test
	public void popArrayTestPositive() {
		StackArray arrayObj = new StackArray(5);

		arrayObj.push(5);
		arrayObj.push(56);
		arrayObj.pop();

		int[] expectedArray = arrayObj.getStack();

		int[] actualArray = new int[] { 5 };

		assertArrayEquals(expectedArray, actualArray);

	}

	//test if an item is added as 0(because array is initialized with 0)
	@Test
	public void pushArrayForZero() {
		StackArray arrayObj = new StackArray(5);

		arrayObj.push(5);
		arrayObj.push(56);
		arrayObj.push(0);

		int[] expectedArray = arrayObj.getStack();

		int[] actualArray = new int[] { 5, 56, 0 };

		assertArrayEquals(expectedArray, actualArray);

	}

	// test for stack overflow
	@Test(expected = AssertionError.class)
	public void StackOverFlowTest() {
		StackArray arrayObj = new StackArray(5);

		arrayObj.push(5);
		arrayObj.push(56);
		arrayObj.push(25);
		arrayObj.push(25);
		arrayObj.push(25);

		arrayObj.push(45);

	}

	//test for empty stack
	@Test(expected = AssertionError.class)
	public void StackArrayEmptyTest() {
		StackArray arrayObj = new StackArray(5);

		arrayObj.pop();

	}

	//test for push item in linked list queue
	@Test
	public void pushListTest() {
		StackList listObj = new StackList();

		listObj.push(5);
		listObj.push(56);
		listObj.push(25);

		int[] expectedArray = listObj.getStack();

		int[] actualArray = new int[] { 25, 56, 5 };

		assertArrayEquals(expectedArray, actualArray);

	}

	//test for popping item in stack linked list
	@Test
	public void popListTest() {
		StackList listObj = new StackList();

		listObj.push(5);
		listObj.push(56);
		listObj.pop();

		int[] expectedArray = listObj.getStack();

		int[] actualArray = new int[] { 5 };

		assertArrayEquals(expectedArray, actualArray);

	}

	//test for empty case
	@Test(expected = AssertionError.class)
	public void StackListEmptyTest() {
		StackList arrayObj = new StackList();

		arrayObj.pop();

	}
}
