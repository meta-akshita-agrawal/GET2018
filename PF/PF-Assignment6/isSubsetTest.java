import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class isSubsetTest {

	private IntSet obj1;
	private IntSet obj2;
	private boolean check;

	
	public isSubsetTest(IntSet obj1, IntSet obj2,boolean check){
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.check = check;
	}
	
	
	@Parameters
	public static Collection<Object[]> input(){
		return Arrays.asList(new Object[][]{
				{new IntSet(new int[]{25,67,3,123}) , new IntSet(new int[]{67,3}), true},
				{new IntSet(new int[]{25,67,3,123}) , new IntSet(new int[]{67,4}), false}
				
		});
	}
	
	@Test
	public void evaluate(){
		assertEquals(obj1.isSubSet(obj2),check);
	}
	
}
