import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;


public class CollegeCounsellingTest {
	
	@Test
	public void PositiveEvaluation() throws BiffException, IOException, RowsExceededException, WriteException{
	
		CollegeCounselling obj = new CollegeCounselling();
		
		obj.readProgramList("C:\\Users\\hp\\Documents\\Programs.xls");
		
		obj.readStudentList("C:\\Users\\hp\\Documents\\Students.xls");
		
		obj.allocation();
		
		obj.writeAllotedList("C:\\Users\\hp\\Documents\\final.xls");
		
		HashMap<String,String> allotedList = obj.readAllotedList("C:\\Users\\hp\\Documents\\final.xls");
		
		assertEquals("Mca",allotedList.get("Komal"));
		assertEquals("MBA",allotedList.get("Pratiksha"));
		assertEquals("Bcom",allotedList.get("Akshita"));
		assertEquals("Msc",allotedList.get("Surbhi"));
		assertEquals("Mtech",allotedList.get("Chirag"));
		assertEquals("BA",allotedList.get("Shubham"));
		assertEquals("Btech",allotedList.get("Ram"));

	}

	@Test
	public void NegativeEvaluation() throws BiffException, IOException, RowsExceededException, WriteException{
	
		CollegeCounselling obj = new CollegeCounselling();
		
		obj.readProgramList("C:\\Users\\hp\\Documents\\Programs.xls");
		
		obj.readStudentList("C:\\Users\\hp\\Documents\\Students.xls");
		
		obj.allocation();
		
		obj.writeAllotedList("C:\\Users\\hp\\Documents\\final.xls");
		
		HashMap<String,String> allotedList = obj.readAllotedList("C:\\Users\\hp\\Documents\\final.xls");
		
		assertEquals("Mca",allotedList.get("Komal"));
		assertEquals("MBA",allotedList.get("Pratiksha"));
		assertEquals("Bcom",allotedList.get("Akshita"));
		assertEquals("Msc",allotedList.get("Surbhi"));
		assertEquals("Mtech",allotedList.get("Chirag"));
		assertEquals("BA",allotedList.get("Shubham"));
		assertNotEquals("BA",allotedList.get("Ram"));
	}
}
