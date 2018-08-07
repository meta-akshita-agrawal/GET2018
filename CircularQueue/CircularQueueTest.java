

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

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

		int[] actualArray = new int[] { 5 };

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

	//SPECIAL CASE WHEN A QUEUE HAVE SPACE BUT STILL THROWS  ERROR STACK OVERFLOW EXCEPTION
	@Test
	public void ArrayIsDequedFromFrontAndHaveNoSpaceAtRear() {
		QueueArray arrayObj = new QueueArray(5);

		arrayObj.enqueue(5);
		arrayObj.enqueue(56);
		arrayObj.enqueue(25);
		arrayObj.enqueue(25);
		arrayObj.enqueue(25);
		arrayObj.dequeue();

		arrayObj.enqueue(89);
		
		int[] expectedArray = arrayObj.getQueue();

		int[] actualArray = new int[] { 89, 56, 25, 25, 25 };

		assertArrayEquals(expectedArray, actualArray);
		
	}
	
}


