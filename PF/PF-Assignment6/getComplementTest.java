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
	
	@Test
	public void negative(){
		IntSet s1 = new IntSet(new int[]{1,2});
		int[] expectedResult = IntStream.rangeClosed(4, 1000).toArray();
		
		assertThat(s1.getComplement(), IsNot.not(IsEqual.equalTo(expectedResult)));
	}
	
}

