public final class Polynomial {

	int[][] polyFunction;

	// Constructor initializing 2 dimensional array
	Polynomial(int[][] polyFunction) {
		this.polyFunction = polyFunction;
		
		for(int i=0;i<this.polyFunction.length;i++){
			if(polyFunction[i][1]==0)
				throw new AssertionError("Coefficients should not be 0");
		}
	}

	/**
	 * Evaluate the polynomial putting value of x 
	 * @param x
	 * @return Evaluated value
	 */
	double evaluate(double x) {
		double result = 0.0;
		for (int i = 0; i < polyFunction.length; i++) {
			result += polyFunction[i][1] * (Math.pow(x, polyFunction[i][0]));
		}
		return result;
	}

	/**
	 * Degree in a polynomial
	 * @return degree
	 */
	int degree() {
		return polyFunction[0][0];
	}

	/**
	 * Add two polynomials
	 * @param p1, object of 2 dimensional array of first polynomial
	 * @param p2, object of 2 dimensional array of second polynomial
	 * @return 2 dimensional array of resulted polynomial
	 */
	int[][] addPoly(Polynomial p1, Polynomial p2) {
		int j = 0;
		int k = 0;
		
		//Evaluating highest degree in both polynomials using ?: operator
		int highestDegree = (p1.polyFunction[0][0] > p2.polyFunction[0][0]) ? p1.polyFunction[0][0]
				: p2.polyFunction[0][0];
		
		//Counter will evaluate number of rows containing zeroes.
		int counter = highestDegree + 1;
		
		//array containing every terms of every degree, if there is no term of that degree it will be initiated as 0. 
		int[][] arrayWithZeroes = new int[highestDegree + 1][2];
		
		for (int i = highestDegree; i >= 0; i--) {
			
			//this will check if both polynomial contains a term of same degree, if yes it will add coefficients of both degree.
			if ((j < p1.polyFunction.length && p1.polyFunction[j][0] == i)
					&& (k < p2.polyFunction.length && p2.polyFunction[k][0] == i)) {
				arrayWithZeroes[i][0] = i;
				arrayWithZeroes[i][1] = p1.polyFunction[j][1]
						+ p2.polyFunction[k][1];
				j = j + 1;
				k = k + 1;
			} 
			//this will check if a term of degree i is in the first polynomial, if yes it will add it as it is.
			else if (j < p1.polyFunction.length && p1.polyFunction[j][0] == i) {
				arrayWithZeroes[i][0] = i;
				arrayWithZeroes[i][1] = p1.polyFunction[j][1];
				j = j + 1;
			} 
			//this will check in second polynomial
			else if (k < p2.polyFunction.length && p2.polyFunction[k][0] == i) {
				arrayWithZeroes[i][0] = i;
				arrayWithZeroes[i][1] = p2.polyFunction[k][1];
				k = k + 1;
			} 
			//if above cases are not satisfied it will simply initiate it with 0
			else {
				arrayWithZeroes[i][0] = 0;
				arrayWithZeroes[i][0] = 0;
				counter--;
			}
		}
		
		
		//New array will remove all zero coefficient terms from the array
		int[][] arrayWithoutZeroes = new int[counter][2];
		int m = 0;
		for (int i = arrayWithZeroes.length - 1; i >= 0; i--) {
			if (arrayWithZeroes[i][1] != 0) {
				arrayWithoutZeroes[m][0] = arrayWithZeroes[i][0];
				arrayWithoutZeroes[m][1] = arrayWithZeroes[i][1];
				m = m + 1;
			}
		}
		return arrayWithoutZeroes;

	}

	/**
	 * Multiply 2 polynomials
	 * @param p1, object of 2 dimensional array of first polynomial
	 * @param p2, object of 2 dimensional array of second polynomial
	 * @return 2 dimensional array of resulted polynomial
	 */
	int[][] multiply(Polynomial p1, Polynomial p2) {
		
		//maximum number of terms a multiplied polynomial can have.
		int termsSize = p1.polyFunction.length * p2.polyFunction.length;
		
		int[][] array = new int[termsSize][2];
		
		int index = 0; // index of created array.
		//this loop will simply add degrees and multiply coefficients from both polynomials and add these values in the new array
		for (int i = 0; i < p1.polyFunction.length; i++) {
			for (int j = 0; j < p2.polyFunction.length; j++) {
				array[index][0] = p1.polyFunction[i][0] + p2.polyFunction[j][0];
				array[index][1] = p1.polyFunction[i][1] * p2.polyFunction[j][1];
				index++;
			}
		}

		int counter = array.length; //This counter will decrement if there are 2 terms of same degree.
		//this array will check for duplicate degree terms in the above array and if found, will add them
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i][0] == array[i + 1][0]) {
				array[i + 1][0] = 0;
				array[i][1] = array[i][1] + array[i + 1][1];
				array[i + 1][1] = 0;
				counter--;
			}
		}
		
		//this array will remove zero coefficient terms
		int[][] finalArray = new int[counter][2];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i][1] != 0) {
				finalArray[k][0] = array[i][0];
				finalArray[k][1] = array[i][1];
				k = k + 1;
			}
		}
		return finalArray;
	}

}
