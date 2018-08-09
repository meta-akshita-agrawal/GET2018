

//Employee class
public class Employee {

	int empId;//employee unique id
	String name;//Name of an employee
	String address;//Address of an employee
	
	//Parameterized constructor
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}
	
	/**
	 * @return employee id of an employee
	 */
	public int getEmpId() {
		return empId;
	}

}
