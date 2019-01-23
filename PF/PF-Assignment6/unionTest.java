import static org.junit.Assert.*;

import org.junit.Test;

public class unionTest {

	@Test
	public void ordinary() {
		IntSet obj1 = new IntSet(new int[] { 3, 25, 67 });
		IntSet obj2 = new IntSet(new int[] { 4, 89, 101 });
		int[] result=new int[] { 3, 4, 25, 67, 89 ,101 };
		assertArrayEquals(obj1.union(obj1,obj2), result);
	}
	
	//test case when there are common elements in both sets
	@Test
	public void commonElements() {
		IntSet obj1 = new IntSet(new int[] { 3, 25, 67 });
		IntSet obj2 = new IntSet(new int[] { 25, 89, 101 });
		int[] result=new int[] { 3, 25, 67, 89 ,101 };
		assertArrayEquals(obj1.union(obj1,obj2), result);
	}
	
	//when both are same.
	@Test
	public void allSame() {
		IntSet obj1 = new IntSet(new int[] { 3, 25, 67 });
		IntSet obj2 = new IntSet(new int[] { 3, 25, 67 });
		int[] result=new int[] { 3,25, 67};
		assertArrayEquals(obj1.union(obj1,obj2), result);
	}
	
	//when one is subset of another.
	@Test
	public void subset() {
		IntSet obj1 = new IntSet(new int[] { 3, 25, 67 });
		IntSet obj2 = new IntSet(new int[] { 3, 25 });
		int[] result=new int[] { 3, 25, 67};
		assertArrayEquals(obj1.union(obj1,obj2), result);
	}
}
