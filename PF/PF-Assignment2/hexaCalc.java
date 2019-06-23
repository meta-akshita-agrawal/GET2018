package hexa;

import java.util.Scanner;

public class hexaCalc {

	//Converts a hexadecimal string to decimal number
	public int hexToDec(String hex) {
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();
		int val = 0;
		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

	//Converts a decimal number to hexadecimal string
	public String decToHex(int hexaNum) {
		String hex = "";
		String digits = "0123456789ABCDEF";
		int remainder;
		while (hexaNum > 0) {
			remainder = hexaNum % 16;
			hex = digits.charAt(remainder) + hex;
			hexaNum = hexaNum / 16;
		}
		return hex;
	}

	//Add 2 hexadecimal strings
	public String add(String hexaStr1, String hexaStr2) {
		int hexaNum1 = hexToDec(hexaStr1);
		int hexaNum2 = hexToDec(hexaStr2);

		int hexaNum = hexaNum1 + hexaNum2;

		String hexaStr = decToHex(hexaNum);

		return hexaStr;
	}

	//Subtract 2 hexadecimal strings
	public String subtract(String hexaStr1, String hexaStr2) {
		int hexaNum1 = hexToDec(hexaStr1);
		int hexaNum2 = hexToDec(hexaStr2);

		int hexaNum = hexaNum1 - hexaNum2;

		if (hexaNum1 < hexaNum2) {
			hexaNum = Math.abs(hexaNum);
			return negativeDec(hexaNum);
		}

		String hexaStr = decToHex(hexaNum);

		return hexaStr;
	}

	//Multiply 2 hexadecimal strings
	public String multiply(String hexaStr1, String hexaStr2) {
		int hexaNum1 = hexToDec(hexaStr1);
		int hexaNum2 = hexToDec(hexaStr2);

		int hexaNum = hexaNum1 * hexaNum2;

		String hexaStr = decToHex(hexaNum);

		return hexaStr;
	}

	//Divide 2 hexadecimal strings
	public String divide(String hexaStr1, String hexaStr2) {
		int hexaNum1 = hexToDec(hexaStr1);
		int hexaNum2 = hexToDec(hexaStr2);

		int hexaNum = hexaNum1 / hexaNum2;

		if (hexaNum1 < hexaNum2) {
			System.out
					.println("First number should be greater than second number");
		}

		String hexaStr = decToHex(hexaNum);

		return hexaStr;
	}

	//Compare strings
	public boolean equal(String hexaStr1, String hexaStr2) {

		if (hexaStr1.equals(hexaStr2)) {
			return true;
		}

		return false;
	}

	//Compare strings
	public boolean greater(String hexaStr1, String hexaStr2) {
		int result = hexaStr1.compareTo(hexaStr2);
		if (result == 1) {
			return true;
		}

		return false;
	}

	//Compare strings
	public boolean lesser(String hexaStr1, String hexaStr2) {
		int result = hexaStr1.compareTo(hexaStr2);
		if (result == 1) {
			return true;
		}

		return false;
	}

	//Handle negative hexadecimal result from subtract method
	public String negativeDec(int hexaNum) {
		int a;
		String hexaStr = "";
		while (hexaNum > 0) {
			a = hexaNum % 2;
			hexaStr = hexaStr + "" + a;
			hexaNum = hexaNum / 2;
		}

		int binary = Integer.parseInt(hexaStr, 2);
		binary = ~binary;
		binary = binary + 1;
		String hexa = Integer.toHexString(binary);
		return hexa;
	}

	
	
	public static void main(String args[]) {
		hexaCalc hc = new hexaCalc();

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("--------------------------------------");
			System.out.println("1.ADD TWO HEXADECIMAL NUMBERS");
			System.out.println("2.SUBTRACT TWO HEXADECIMAL NUMBERS");
			System.out.println("3.MULTIPLY TWO HEXADECIMAL NUMBERS");
			System.out.println("4.DIVIDE TWO HEXADECIMAL NUMBERS");
			System.out
					.println("5.COMPARE IF TWO HEXADECIMAL NUMBERS ARE EQUAL");
			System.out
					.println("6.COMPARE IF FIRST NUMBER IS GREATER THAN SECOND NUMBER");
			System.out
					.println("7.COMPARE IF FIRST NUMBER IS LESSER THAN SECOND NUMBER");
			System.out.println("8.Enter to exit.");
			System.out.println("--------------------------------------");

			System.out
					.println("Enter 2 hexadecimal numbers on which you want to perform above operations.");

			String hexaStr1 = sc.next();
			String hexaStr2 = sc.next();

			System.out.println("Enter your choice.");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("ADDED RESULT: "
						+ hc.add(hexaStr1, hexaStr2));
				break;

			case 2:
				System.out.println("SUBTRACTED RESULT: "
						+ hc.subtract(hexaStr1, hexaStr2));
				break;

			case 3:
				System.out.println("MULTIPLIED RESULT: "
						+ hc.multiply(hexaStr1, hexaStr2));
				break;

			case 4:
				System.out.println("DIVIDED RESULT"
						+ hc.divide(hexaStr1, hexaStr2));
				break;

			case 5:
				if (hc.equal(hexaStr1, hexaStr2)) {
					System.out.println("The two numbers are equal");
				} else {
					System.out.println("The two numbers are not equal");
				}
				break;

			case 6:
				if (hc.greater(hexaStr1, hexaStr2)) {
					System.out
							.println("The first number is greater than second.");
				} else {
					System.out
							.println("The first number is not greater than second.");
				}
				break;

			case 7:
				if (hc.greater(hexaStr1, hexaStr2)) {
					System.out.println("The first number is less than second.");
				} else {
					System.out
							.println("The first number is not less than second.");
				}
				break;

			case 8:
				System.exit(0);
				sc.close();
				break;

			default:
				System.out.println("wrong choice.");
				break;
			}
		} while (true);
		
	}

}
