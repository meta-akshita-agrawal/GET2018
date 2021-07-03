import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	//test for enqueue in array
	@Test
	public void enqArrayTestPositive() {
		QueueArray arrayObj = new QueueArray(5);

		arrayObj.enqueue(5);
		arrayObj.enqueue(56);
		arrayObj.enqueue(25);

		int[] expectedArray = arrayObj.getQueue();

		int[] actualArray = new int[] { 5, 56, 25 };

		assertArrayEquals(expectedArray, actualArray);

	}
	
	//test for dequeue in array
	@Test
	public void deqArrayTestPositive() {
		QueueArray arrayObj = new QueueArray(5);

		arrayObj.enqueue(5);
		arrayObj.enqueue(56);
		arrayObj.dequeue();

		int[] expectedArray = arrayObj.getQueue();

		int[] actualArray = new int[] { 56 };

		assertArrayEquals(expectedArray, actualArray);

	}

	//test if an item is added as 0(because array is initialized with 0)
	@Test
	public void enqArrayForZero() {
		QueueArray arrayObj = new QueueArray(5);

		arrayObj.enqueue(5);
		arrayObj.enqueue(56);
		arrayObj.enqueue(0);

		int[] expectedArray = arrayObj.getQueue();

		int[] actualArray = new int[] { 5, 56, 0 };

		assertArrayEquals(expectedArray, actualArray);

	}

	//test if queue is full in array
	@Test(expected = AssertionError.class)
	public void QueueOverFlowTest() {
		QueueArray arrayObj = new QueueArray(5);

		arrayObj.enqueue(5);
		arrayObj.enqueue(56);
		arrayObj.enqueue(25);
		arrayObj.enqueue(25);
		arrayObj.enqueue(25);

		arrayObj.enqueue(45);

	}

	//test for empty queue in array
	@Test(expected = AssertionError.class)
	public void QueueArrayEmptyTest() {
		QueueArray arrayObj = new QueueArray(5);

		arrayObj.dequeue();

	}

	//test for enqueue in linked list
	@Test
	public void enqListTest() {
		QueueList listObj = new QueueList();

		listObj.enqueue(5);
		listObj.enqueue(56);
		listObj.enqueue(25);

		int[] expectedArray = listObj.getQueue();

		int[] actualArray = new int[] { 5, 56, 25 };

		assertArrayEquals(expectedArray, actualArray);

	}

	//test for dequeue in linked list
	@Test
	public void deqListTest() {
		QueueList listObj = new QueueList();

		listObj.enqueue(5);
		listObj.enqueue(56);
		listObj.dequeue();

		int[] expectedArray = listObj.getQueue();

		int[] actualArray = new int[] { 56 };

		assertArrayEquals(expectedArray, actualArray);

	}

	//test for empty queue in linked list
	@Test(expected = AssertionError.class)
	public void QueueListEmptyTest() {
		QueueList arrayObj = new QueueList();

		arrayObj.dequeue();

	}
}
