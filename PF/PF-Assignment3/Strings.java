package assignment3;

import java.util.Scanner;

public class Strings {

	/**
	*Check if 2 strings are equal
	*@param First String
	*@param Second String
	*@return 1 if both strings are equal  else 0
	*/
	public int isEqual(String String1, String String2) {
		if (String1.length() == String2.length()) {
			int i = 0;
			while (String1.charAt(i) == String2.charAt(i)) {
				if (i == String1.length() - 1) {
					return 1;
				}
				i = i + 1;
			}
			return 0;
		}
		return 0;
	}

	/**
	 * Reverse a string
	 * @param A string to reverse
	 * @return Reversed string 
	 */
	public String reverse(String str) {
		String newString = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			newString = newString + str.charAt(i);
		}
		return newString;
	}

	/**
	 * Change upperCase letter to lowerCase and vice-versa
	 * @param A string to perform above operation
	 * @return Changed String
	 */
	public String caseChange(String str) {
		String newString = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				char lowerToUpper = (char) (str.charAt(i) - 32);
				newString = newString + lowerToUpper;
			} else if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				char upperToLower = (char) (str.charAt(i) + 32);
				newString = newString + upperToLower;
			} else {
				newString = newString + str.charAt(i);
			}
		}
		return newString;
	}

	/**
	 * Retrieve largest word from the sentence, passed as a string
	 * @param A string to perform above operation
	 * @return the largest word acquired given that if two words have same length print last word 
	 */
	String largestWord(String str) {
		int maximum = 0;
		int currentPointer = 0;
		int prevPointer = 0;
		String largest = null;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isWhitespace(str.charAt(i)) || i == str.length() - 1) {
				if (maximum <= currentPointer - prevPointer) {
					maximum = currentPointer - prevPointer;
					largest = "";
					if (i == str.length() - 1) {
						largest = largest
								+ str.substring(prevPointer, str.length() - 1)
								+ str.charAt(i);
					} else {
						largest = largest
								+ str.substring(prevPointer, currentPointer + 1);
					}
				}
				prevPointer = currentPointer;
			}
			currentPointer++;
		}
		return largest;
	}

	public static void main(String[] args) {

		Strings stringObj = new Strings();
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("----------------------------------------");
			System.out.println("1.COMPARE 2 STRINGS WHETHER THEY ARE EQUAL.");
			System.out.println("2.REVERSE THE STRING");
			System.out
					.println("3.CHANGE ALL UPPERCASE LETTERS TO LOWERCASE AND VICE-VERSA");
			System.out.println("4.RETRIEVE LARGEST WORD FROM THE SENTENCE");
			System.out.println("5.EXIT");
			System.out.println("----------------------------------------");

			System.out.println("Enter your choice");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.println("Enter any 2 Strings");
				String inputString1 = sc.nextLine();
				String inputString2 = sc.nextLine();
				System.out.println(stringObj
						.isEqual(inputString1, inputString2));
				break;
			case 2:
				System.out.println("Enter any String");
				String reverseString = sc.nextLine();
				System.out.println(stringObj.reverse(reverseString));
				break;
			case 3:
				System.out.println("Enter any String");
				String caseString = sc.nextLine();
				System.out.println(stringObj.caseChange(caseString));
				break;
			case 4:
				System.out.println("Enter any String");
				String largestString = sc.nextLine();
				System.out.println(stringObj.largestWord(largestString));
				break;
			case 5:
				System.exit(0);
				sc.close();
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		} while (true);

	}
}
