import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CollegeCounselling {

	Excel excelObj = new Excel();

	ArrayList<Program> programList = new ArrayList<>();//program list having program name and capacity of each
	
	Queue<Student> studentList = new LinkedList<>();//students list with student name and their preferences

	HashMap<String, String> allotedList = new HashMap<>();//list that will be made after allotment of each student


	/**
	 * Reads Program list
	 * @param location
	 * @throws BiffException
	 * @throws IOException
	 */
	public void readProgramList(String location) throws BiffException, IOException {
		this.programList = excelObj.readPrograms(location);
	}

	/**
	 * Reads student list
	 * @param location
	 * @throws BiffException
	 * @throws IOException
	 */
	public void readStudentList(String location) throws BiffException, IOException {
		this.studentList = excelObj.readStudents(location);
	}

	/**
	 * Checks if a program have space for new allotment
	 * @param index, program name index
	 * @return true if it have space else false
	 */
	public boolean haveSpace(int index) {
		return programList.get(index).getCapacity() != 0;
	}

	
	/**
	 * Allocated students to programs 
	 */
	public void allocation() {

		int numberOfPreferences = studentList.peek().getNumberOfPreferences();

		while (!studentList.isEmpty()) { //iterate over student list till its not empty 
			Student frontStudent = studentList.peek(); // retrieves student at the front of queue
			
			for (int i = 0; i < numberOfPreferences; i++) { //iterate over all student preferences
				for (int j = 0; j < programList.size(); j++) {
					
					String programName = programList.get(j).getProgramName();

					if (frontStudent.getPreference(i).equals(programName) && haveSpace(j)) {//if any of preference is equal to program name and that program name has space
						
						allotedList.put(frontStudent.getStudentName(), programName);//adds them to alloted list
						programList.get(j).setCapacity(1);//sets capacity to one less now
						break;
					}
				}
			}
			if (!studentList.isEmpty()) {
				studentList.remove();//If student list gets empty there will be nothing to remove
			}
		}
	}

	/**
	 * Writes alloted list to the excel file
	 * @param location
	 * @throws RowsExceededException
	 * @throws BiffException
	 * @throws WriteException
	 * @throws IOException
	 */
	public void writeAllotedList(String location)
			throws RowsExceededException, BiffException, WriteException, IOException {
		excelObj.writeAllotedList(location, this.allotedList);
	}
	
	/**
	 * Reads alloted list for testing
	 * @param location
	 * @return alloted list
	 */
	public HashMap<String,String> readAllotedList(String location) {
		return excelObj.readAllotedList(location); 
	}
}
