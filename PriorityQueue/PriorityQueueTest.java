import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.Matchers.*;



public class PriorityQueueTest {

	@Test
	public void positiveAdd(){
	
		PriQueue obj = new PriQueue(5);
		
		obj.add(new Item("akshita",2));
		obj.add(new Item("agrawal",3));
		obj.add(new Item("e018/1036",5));
		
		Item[] qarr = obj.getQueueArray();
		
		Item[] arr = {null,new Item("e018/1036",5),(new Item("agarwal",3)),(new Item("akshita",2)),null,null};
		
		assertThat(arr, samePropertyValuesAs(qarr));

	}
	
	@Test(expected = AssertionError.class)
	public void overflow(){
	
		PriQueue obj = new PriQueue(5);
		
		obj.add(new Item("akshita",2));
		obj.add(new Item("agrawal",3));
		obj.add(new Item("e018/1036",5));
		obj.add(new Item("e018/1036zcs",9));
		obj.add(new Item("dan\6",5));
		obj.add(new Item("easd",5));

	}
	
	
	
	@Test
	public void positiveRemoval(){
	
		PriQueue obj = new PriQueue(5);
		
		obj.add(new Item("akshita",2));
		obj.add(new Item("agrawal",3));
		obj.add(new Item("e018/1036",5));
		
		obj.remove();
		
		Item[] qarr = obj.getQueueArray();
		
		Item[] arr = {null,(new Item("agarwal",3)),(new Item("akshita",2)),null,null,null};
		
		assertThat(arr, samePropertyValuesAs(qarr));

	}
	
	@Test(expected = AssertionError.class)
	public void empty(){
	
		PriQueue obj = new PriQueue(5);
		
		obj.add(new Item("akshita",2));
		obj.add(new Item("agrawal",3));
		obj.add(new Item("e018/1036",5));
		
		obj.remove();
		obj.remove();
		obj.remove();
		obj.remove();
	}
	
	
}
