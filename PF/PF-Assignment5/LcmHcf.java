package recursionAssignment;

public class LcmHcf {
	
	
	/**
	 * Evaluate hcf of 2 numbers
	 * @param first number
	 * @param second number
	 * @return hcf of number1 and number2
	 */
	int hcf(int number1, int number2)
    {
        if (number2 != 0)
            return hcf(number2, number1 % number2);
        else
            return number1;
    }
	
	
	/**
	 * Evaluate lcm of 2 numbers
	 * @param first number
	 * @param second number
	 * @return lcm of number1 and number2
	 */
	int lcm(int number1, int number2) {
		int number;
		number = (number1 * number2)/hcf(number1,number2);
		return number;
	}

	
}
