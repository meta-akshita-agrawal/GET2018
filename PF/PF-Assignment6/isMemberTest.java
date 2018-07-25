import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class isMemberTest {

	private IntSet obj1;
	private int member;
	private boolean check;

	
	public isMemberTest(IntSet obj1,int member, boolean check){
		this.obj1 = obj1;
		this.member = member;
		this.check = check;
	}
	
	
	@Parameters
	public static Collection<Object[]> input(){
		return Arrays.asList(new Object[][]{
				{new IntSet(new int[]{25,67,3,123}) , 67, true},
				{new IntSet(new int[]{25,67,3,123}) , 69, false}
				
		});
	}
	
	@Test
	public void evaluate(){
		assertEquals(obj1.isMember(member),check);
	}
	
}

