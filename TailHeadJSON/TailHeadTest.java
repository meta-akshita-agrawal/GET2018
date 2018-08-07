package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

public class TailHeadTest {

	@Test
	public void positiveEvaluation() throws FileNotFoundException, IOException, ParseException {
		
		NestedList nestedlist = new List();
		
		JSON obj = new JSON();
		
		nestedlist = obj.readJSON("C:\\Users\\hp\\Desktop\\test.json.txt");
		
		NestedList newNestedList = nestedlist.getValueByPosition("TH");
		
		if(newNestedList instanceof List) {
			throw new AssertionError("A list is present at this position rather than value");
		}
		else {
			int value = ((Value) newNestedList).getValue();
			assertEquals(value,70);
		}
	}
	
	@Test
	public void negativeEvaluation() throws FileNotFoundException, IOException, ParseException {
		
		NestedList nestedlist = new List();
		
		JSON obj = new JSON();
		
		nestedlist = obj.readJSON("C:\\Users\\hp\\Desktop\\test.json.txt");
		
		NestedList newNestedList = nestedlist.getValueByPosition("TH");
		
		if(newNestedList instanceof List) {
			throw new AssertionError("A list is present at this position rather than value");
		}
		else {
			int value = ((Value) newNestedList).getValue();
			assertNotEquals(value,72);
		}
	}
	
	@Test(expected = AssertionError.class)
	public void errorWhenListPresentInsteadOfValue() throws FileNotFoundException, IOException, ParseException {
		
		NestedList nestedlist = new List();
		
		JSON obj = new JSON();
		
		nestedlist = obj.readJSON("C:\\Users\\hp\\Desktop\\test.json.txt");
		
		NestedList newNestedList = nestedlist.getValueByPosition("TTHT");
		
		if(newNestedList instanceof List) {
			throw new AssertionError("A list is present at this position rather than value");
		}
		else {
			int value = ((Value) newNestedList).getValue();
			assertEquals(value,72);
		}
	}
}
