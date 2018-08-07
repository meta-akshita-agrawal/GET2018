
public class Program {
	
	String programName;
	int capacity;
	
	//Parameterized constructor
	Program(String programName, int capacity){
		this.programName = programName;
		this.capacity = capacity;
	}
	
	/**
	 * @return program name
	 */
	public String getProgramName() {
		return this.programName;
	}
	
	/**
	 * @return capacity of a program
	 */
	public int getCapacity() {
		return this.capacity;
	}
	
	/**
	 * Sets capacity of a program 
	 * @param allocatedCapacity
	 */
	public void setCapacity(int allotedCapacity) {
		this.capacity = this.capacity - allotedCapacity;
	}

}

