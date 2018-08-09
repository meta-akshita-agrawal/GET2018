import java.util.ArrayList;
import java.util.Collections;

public class NoDuplicateCollection{
	
	//creating an array list for no duplication
	ArrayList<Employee> noDuplicateList = new ArrayList<>();

	//Default constructor
	NoDuplicateCollection(){
		this.noDuplicateList = new ArrayList<>();//creating a new array list
	}
	
	/**
	 * Adds an employee with all its fields in list
	 * @param e, employee instance
	 */
	public void add(Employee e){
		for(int i=0;i<this.noDuplicateList.size();i++){
			if(e.empId == this.noDuplicateList.get(i).getEmpId()){
				throw new AssertionError("This id already exists");//throw error if same id exists in the list
			}
		}
		
		this.noDuplicateList.add(e);//adding
	}
	
	/**
	 * Removes an employee from list 
	 * @param e, employee instance
	 */
	public void remove(Employee e){
		
		if(this.noDuplicateList.size() == 0){
			throw new AssertionError("Nothing to remove");//throw error if list is empty
		}
		
		this.noDuplicateList.remove(e);//removing
	}
	
	/**
	 * Sorts according to lexical order of names
	 * @return sorted list
	 */
	public ArrayList<Employee> sortByName(){
		Collections.sort(this.noDuplicateList, new SortByName());//invoking comparator of sortByName
		return this.noDuplicateList;
	}
	
	/**
	 * Sorts according to natural order
	 * i.e.: according to ascending employee id
	 * @return sorted list
	 */
	public ArrayList<Employee> sortByNaturalOrder(){
		Collections.sort(this.noDuplicateList, new SortByNaturalOrder());
		return this.noDuplicateList;
	}
	
	/**
	 * @return collection list
	 */
	public ArrayList<Employee> getCollection(){
		return this.noDuplicateList;
	}
}
