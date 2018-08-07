import java.io.File;
import java.io.IOException;
import java.util.*;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;


public class Excel {

	/**
	 * Read students from an excel file having student name and their 5 preferences
	 * @param location, excel file location needed to read
	 * @return queue of students
	 * @throws BiffException
	 * @throws IOException
	 */
	public Queue<Student> readStudents(String location) throws BiffException, IOException {

		Queue<Student> studentList = new LinkedList<>();

		try {
			Workbook workbook = Workbook.getWorkbook(new java.io.File(location));//creates a workbook of the located excel file

			Sheet sheet1 = workbook.getSheet(0);//retrieves sheet 1 from excel sheet

			int rows = sheet1.getRows();//retrieve number of rows
			int columns = sheet1.getColumns();//number of columns

			//NOTE THAT getCell(column,row) takes column as first parameter and row as second
			for (int i = 1; i < rows; i++) {
				String studentName = sheet1.getCell(0, i).getContents();//get content from column 0 and row i
				ArrayList<String> listOfPreferences = new ArrayList<>();//creates a list of preferences
				for (int j = 1; j < columns; j++) {
					listOfPreferences.add(sheet1.getCell(j, i).getContents());//adding preferences from the cells
				}
				studentList.add(new Student(studentName, listOfPreferences));//adding both in student list
			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return studentList;
	}

	/**
	 * Read Program list containing Program name and capacity it can hold
	 * @param location, excel sheet location needed to read
	 * @return programs list
	 * @throws BiffException
	 * @throws IOException
	 */
	public ArrayList<Program> readPrograms(String location) throws BiffException, IOException {

		ArrayList<Program> programList = new ArrayList<>();

		try {
			Workbook workbook = Workbook.getWorkbook(new java.io.File(location));

			Sheet sheet1 = workbook.getSheet(0);

			int rows = sheet1.getRows();

			for (int i = 1; i < rows; i++) {
				String programName = sheet1.getCell(0, i).getContents();
				int capacity = Integer.valueOf(sheet1.getCell(1, i).getContents());//retrieving capacity as string and casting it to integer
				programList.add(new Program(programName, capacity));
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return programList;
	}

	/**
	 * Writes the list in an excel sheet
	 * @param location, empty excel file location
	 * @param allotedList, list that needed to be written in excel sheet
	 * @throws BiffException
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	public void writeAllotedList(String location,HashMap<String, String> allotedList)
			throws BiffException, IOException, RowsExceededException, WriteException {
		
		WritableWorkbook workbook = null;

		try {
			File file = new File(location);//creates an instance of file for the excel sheet

			workbook = Workbook.createWorkbook(file); // creating workbook

			WritableSheet sheet = workbook.createSheet("final", 0); //creating a sheet and giving name to it as "final"

			sheet.addCell(new Label(0, 0, "Student Name")); //adding label as student name in the first column
			sheet.addCell(new Label(1, 0, "Program Name"));//adding label as program name in the second column

			int i = 1;//adding values from second row

			for (String key : allotedList.keySet()) {//iterating through alloted list
				
				String studentName = key; //adding student name as key
				String programName = allotedList.get(key); //adding program name as value

				Label label1 = new Label(0, i, studentName);
				Label label2 = new Label(1, i, programName);

				sheet.addCell(label1);
				sheet.addCell(label2);

				i++;
			}
			workbook.write(); //WRITING WORKBOOK
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (workbook != null) {
				try {
					workbook.close();//CLOSING WORKBOOK
				} catch (IOException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
	/**
	 * Reading alloted list from excel sheet
	 * @param location, alloted excel file location
	 * @return alloted list
	 */
	public HashMap<String,String> readAllotedList(String location){
		
		HashMap<String,String> allotedList = new HashMap<>();
		
		try {
			Workbook workbook = Workbook.getWorkbook(new java.io.File(location));

			Sheet sheet1 = workbook.getSheet(0);

			int rows = sheet1.getRows();

			for (int i = 1; i < rows; i++) {
				String studentName = sheet1.getCell(0, i).getContents();
				String programName = sheet1.getCell(1, i).getContents();
				allotedList.put(studentName, programName);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return allotedList;
	}
}