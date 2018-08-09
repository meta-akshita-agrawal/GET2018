import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
	
	//positive test case for adding values in collection
	@Test
	public void positiveAdd(){
		
		NoDuplicateCollection obj = new NoDuplicateCollection();
		
		obj.add(new Employee(2,"ak","jasdbcsd"));
		obj.add(new Employee(3,"aa","jasdakxccsd"));
		
		ArrayList<Employee> actualList = obj.getCollection();
		
		ArrayList<Employee> expectedList = new ArrayList<>();
		
		expectedList.add(new Employee(2,"ak","jasdbcsd"));
		expectedList.add(new Employee(3,"aa","jasdakxccsd"));
		
		if(expectedList.size() != actualList.size()){
			throw new AssertionError("Size varies for both lists");
		}
		else{
			for(int i=0;i<expectedList.size();i++){
				assertEquals(expectedList.get(i).empId,actualList.get(i).empId);
				assertEquals(expectedList.get(i).name,actualList.get(i).name);
				assertEquals(expectedList.get(i).address,actualList.get(i).address);
			}
		}
	}
	
	//negative test case for adding values in collection
	@Test
	public void negativeAdd(){
		
		NoDuplicateCollection obj = new NoDuplicateCollection();
		
		obj.add(new Employee(1,"ak","jasdbcsd"));
		obj.add(new Employee(3,"aa","jasdakxccsd"));
		
		ArrayList<Employee> actualList = obj.getCollection();
		
		ArrayList<Employee> expectedList = new ArrayList<>();
		
		expectedList.add(new Employee(2,"ak","jasdbcsd"));
		expectedList.add(new Employee(4,"aa","jasdakxccsd"));
		
		if(expectedList.size() != actualList.size()){
			throw new AssertionError("Size varies for both lists");
		}
		else{
			for(int i=0;i<expectedList.size();i++){
				assertNotEquals(expectedList.get(i).empId,actualList.get(i).empId);
				assertEquals(expectedList.get(i).name,actualList.get(i).name);
				assertEquals(expectedList.get(i).address,actualList.get(i).address);
			}
		}
	}
	
	//test case for sorting employee by name 
	@Test
	public void sortByNameTest(){
		
		NoDuplicateCollection obj = new NoDuplicateCollection();
		
		obj.add(new Employee(2,"ak","jasdbcsd"));
		obj.add(new Employee(3,"aa","jasdakxccsd"));
		
		ArrayList<Employee> actualList = obj.sortByName();
		
		ArrayList<Employee> expectedList = new ArrayList<>();
		
		expectedList.add(new Employee(3,"aa","jasdakxccsd"));
		expectedList.add(new Employee(2,"ak","jasdbcsd"));
		
		if(expectedList.size() != actualList.size()){
			throw new AssertionError("Size varies for both lists");
		}
		else{
			for(int i=0;i<expectedList.size();i++){
				assertEquals(expectedList.get(i).empId,actualList.get(i).empId);
				assertEquals(expectedList.get(i).name,actualList.get(i).name);
				assertEquals(expectedList.get(i).address,actualList.get(i).address);
			}
		}
	}
	
	//test case for sorting employee by natural order
	@Test
	public void sortByNaturalOrderTest(){
		
		NoDuplicateCollection obj = new NoDuplicateCollection();
		
		obj.add(new Employee(2,"ak","jasdbcsd"));
		obj.add(new Employee(3,"aa","jasdakxccsd"));
		
		ArrayList<Employee> actualList = obj.sortByNaturalOrder();
		
		ArrayList<Employee> expectedList = new ArrayList<>();
		
		expectedList.add(new Employee(2,"ak","jasdbcsd"));
		expectedList.add(new Employee(3,"aa","jasdakxccsd"));
		
		if(expectedList.size() != actualList.size()){
			throw new AssertionError("Size varies for both lists");
		}
		else{
			for(int i=0;i<expectedList.size();i++){
				assertEquals(expectedList.get(i).empId,actualList.get(i).empId);
				assertEquals(expectedList.get(i).name,actualList.get(i).name);
				assertEquals(expectedList.get(i).address,actualList.get(i).address);
			}
		}
	}
	
	//test case when duplicated id is added
	@Test(expected = AssertionError.class)
	public void duplicateIdTest(){
		
		NoDuplicateCollection obj = new NoDuplicateCollection();
		
		obj.add(new Employee(2,"ak","jasdbcsd"));
		obj.add(new Employee(3,"aa","jasdakxccsd"));
		
		obj.add(new Employee(3,"akshita","bhjasdakxccsd"));
	}
	
	
}
