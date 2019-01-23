import static org.junit.Assert.*;

import org.junit.Test;


public class isSubsetTest {

	
	@Test
	public void ordinary(){
		
		IntSet obj1 = new IntSet(new int[]{3,25,67,123});
		IntSet obj2 = new IntSet(new int[]{3,25});
		boolean check = true;
		assertEquals(obj1.isSubSet(obj2),check);
	}
	
	//if both sets are same
	@Test
	public void wholeSubSet(){
		
		IntSet obj1 = new IntSet(new int[]{3,25,67,123});
		IntSet obj2 = new IntSet(new int[]{3,25,67,123});
		boolean check = true;
		assertEquals(obj1.isSubSet(obj2),check);
	}
	
	//if only one element is there in 2nd set and it is member of 1st set.
	@Test
	public void oneElement(){
		
		IntSet obj1 = new IntSet(new int[]{3,25,67,123});
		IntSet obj2 = new IntSet(new int[]{25});
		boolean check = true;
		assertEquals(obj1.isSubSet(obj2),check);
	}
	
	@Test
	public void negative(){
		
		IntSet obj1 = new IntSet(new int[]{3,25,67,123});
		IntSet obj2 = new IntSet(new int[]{25,123});
		boolean check = true;
		assertNotEquals(obj1.isSubSet(obj2),check);
	}
	
	//set should not be empty
	@Test(expected = AssertionError.class)
	public void empty(){
		
		IntSet obj1 = new IntSet(new int[]{3,25,67,123});
		IntSet obj2 = new IntSet(new int[]{});
		boolean check = true;
		assertEquals(obj1.isSubSet(obj2),check);
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
