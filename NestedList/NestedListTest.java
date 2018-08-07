import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class NestedListTest {	
	
	
	@Test
	public void positiveSum() {
		
		NestedList nl = new List();
		
		
		ArrayList<NestedList> list1 = new ArrayList<>();
	
		list1.add(new Value(6));
		list1.add(new Value(7));
		
		
		ArrayList<NestedList> list2 = new ArrayList<>();
		
		list2.add(new Value(4));
		list2.add(new Value(789));
		list1.add(new List(list2));
		
		ArrayList<NestedList> list3 = new ArrayList<>();
		list3.add(new List(list1));
		list3.add(new Value(400));
		
		nl.add(new Value(5));
		nl.add(new Value(70));
		nl.add(new List(list2));
		nl.add(new List(list1));
		nl.add(new List(list3));
		
		int sum = nl.sum();
		
		assertEquals(sum,2880);
	}
	
	@Test
	public void positiveLargestValue() {
		
		NestedList nl = new List();
		
		
		ArrayList<NestedList> list1 = new ArrayList<>();
	
		list1.add(new Value(6));
		list1.add(new Value(7));
		
		
		ArrayList<NestedList> list2 = new ArrayList<>();
		
		list2.add(new Value(4));
		list2.add(new Value(789));
		list1.add(new List(list2));
		
		ArrayList<NestedList> list3 = new ArrayList<>();
		list3.add(new List(list1));
		list3.add(new Value(400));
		
		nl.add(new Value(5));
		nl.add(new Value(70));
		nl.add(new List(list2));
		nl.add(new List(list1));
		nl.add(new List(list3));
		
		int largestValue = nl.largestValue();
		
		assertEquals(largestValue,789);
	}
	
	public void positiveFindValue() {
		
		NestedList nl = new List();
		
		
		ArrayList<NestedList> list1 = new ArrayList<>();
	
		list1.add(new Value(6));
		list1.add(new Value(7));
		
		
		ArrayList<NestedList> list2 = new ArrayList<>();
		
		list2.add(new Value(4));
		list2.add(new Value(789));
		list1.add(new List(list2));
		
		ArrayList<NestedList> list3 = new ArrayList<>();
		list3.add(new List(list1));
		list3.add(new Value(400));
		
		nl.add(new Value(5));
		nl.add(new Value(70));
		nl.add(new List(list2));
		nl.add(new List(list1));
		nl.add(new List(list3));
		
		ArrayList<Integer> searchIndices = nl.findValue(400);
		
		if(searchIndices == null){
			throw new AssertionError("Value not found");
		}
		
		int[] searchPathIndices = new int[searchIndices.size()];
	
		for(int i=0;i<searchIndices.size();i++) {
			searchPathIndices[i] = searchIndices.get(i);
		}
		
		int[] expectedArray = {1,4};
		
		assertArrayEquals(searchPathIndices,expectedArray);
	}
}
