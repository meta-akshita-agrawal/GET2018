import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;



import java.util.stream.IntStream;


public class getComplementTest {

	
	@Test
	public void positive(){
		IntSet s1 = new IntSet(new int[]{1,2});
		int[] expectedResult = IntStream.rangeClosed(3, 1000).toArray();
		
		assertArrayEquals(s1.getComplement(),expectedResult);
	}
	
	//actual result was set {3..1000} but expected was different 
	@Test
	public void negative(){
		IntSet s1 = new IntSet(new int[]{1,2});
		int[] expectedResult = IntStream.rangeClosed(4, 1000).toArray();
		
		assertThat(s1.getComplement(), IsNot.not(IsEqual.equalTo(expectedResult)));
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

