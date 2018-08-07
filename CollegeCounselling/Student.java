import java.util.ArrayList;

public class Student{

	String studentName;
	ArrayList<String> listOfPreferences = new ArrayList<>();//List of preferences of program names 
	
	//Parameterized Constructor
	public Student(String studentName, ArrayList<String> listOfPreferences) {
		this.studentName = studentName;
		this.listOfPreferences = listOfPreferences;
	}
	
	/**
	 * @return student name
	 */
	public String getStudentName() {
		return this.studentName;
	}
	
	/**
	 * @param index,preference list index
	 * @return ith preference
	 */
	public String getPreference(int index) {
		return this.listOfPreferences.get(index);
	}
	
	/**
	 * @return number of preference every student can have
	 */
	public int getNumberOfPreferences() {
		return this.listOfPreferences.size();
	}

}