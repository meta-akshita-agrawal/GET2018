package assignment3;

import java.util.Scanner;

public class Marksheet {
	int[] grades;

	/**
	 * calculates average of all grades of students
	 * @param an array of students grades, requires that grade lies between 0 to 100 inclusive
	 * @return average such that floating point value is Upto 2 decimal
	 */
	double averageGrades(int[] grades)throws ArithmeticException{
		double average = 0;
		for (int value : grades) {
			average += value;
		}
		average = average / grades.length;
		return Math.round(average * 100.0) / 100.0;
	}

	/**
	 * retrieves maximum grade from the list of grades
	 * @param an array of students grades, requires that grade lies between 0 to 100 inclusive
	 * @return an integer maximum
	 * @throws ArithmeticException
	 */
	int maxGrade(int[] grades) throws ArithmeticException{
		int maximum = 0;
		for (int value : grades) {
			if (maximum < value) {
				maximum = value;
			}
		}
		return maximum;
	}

	/**
	 * retrieves minimum grade from the list of grades 
	 * @param an array of students grades, requires that grade lies between 0 to 100 inclusive
	 * @return an integer minimum
	 * @throws ArithmeticException
	 */
	int minGrade(int[] grades) throws ArithmeticException{
		int minimum = grades[0];
		for (int value : grades) {
			if (minimum > value) {
				minimum = value;
			}
		}
		return minimum;
	}

	/**
	 * Calculates percentage of students passed
	 * @param an array of students grades, requires that grade lies between 0 to 100 inclusive
	 * @return percentage such that floating point value is Upto 2 decimal
	 * @throws ArithmeticException
	 */
	double studentsPassed(int[] grades) throws ArithmeticException{
		int numOfStudentsPass = 0;
		double percentage = 0.0;
		for (int value : grades) {
			if (value >= 40) {
				numOfStudentsPass++;
			}
		}
		percentage = ((double)numOfStudentsPass / grades.length) * 100;
		return Math.round(percentage*100.0)/100.0;
	}

	
	public static void main(String[] args) {
		
		int[] grades;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of students.");
		int numOfStudents = sc.nextInt();

		grades = new int[numOfStudents];
		System.out.println("Enter grades of each student");
		for (int i = 0; i < numOfStudents; i++) {
			grades[i] = sc.nextInt();
		}

		Marksheet obj = new Marksheet();

		do{
			System.out.println("---------------------------------------");
			System.out.println("1.Get average of all grades.");
			System.out.println("2.Get maximum of all grades.");
			System.out.println("3.Get minimum of all grades.");
			System.out.println("4.Get percentage of students passed.");
			System.out.println("5.Exit");
			System.out.println("---------------------------------------");
	
			System.out.println("ENTER YOUR CHOICE:");

		int choice = sc.nextInt();
		sc.nextLine();

			switch (choice) {

			case 1:
				System.out.println("AVERAGE:" + obj.averageGrades(grades));
				break;
			case 2:
				System.out.println("MAXIMUM" + obj.maxGrade(grades));
				break;
			case 3:
				System.out.println("MINIMUM" + obj.minGrade(grades));
				break;
			case 4:
				System.out.println("PERCENTAGE:" + obj.studentsPassed(grades)
						+ "%");
				break;
			case 5:
				System.exit(0);
				sc.close();
			default:
				System.out.println("Wrong Choice");
				break;
			}

		} while (true);

	}

}
